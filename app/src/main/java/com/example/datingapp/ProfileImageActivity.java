package com.example.datingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileImageActivity extends AppCompatActivity {
    ImageView img;
    FloatingActionButton fBtn;
    Button nextBtn;
    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_image);

        img = findViewById(R.id.img);
        fBtn = findViewById(R.id.fab_camera);
        nextBtn = findViewById(R.id.nextBtn);

        // "Next" button click listener
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if an image has been selected
                if (selectedImageUri != null) {
                    // Image selected, proceed to next activity
                    Intent i = new Intent(ProfileImageActivity.this, DashBoardActivity.class);
                    i.putExtra("imageUri", selectedImageUri.toString()); // Pass the image URI to the next activity
                    startActivity(i);
                } else {
                    // No image selected, show a Toast
                    Toast.makeText(ProfileImageActivity.this, "Please select a profile image", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Camera button click listener
        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the image picker to select an image
                ImagePicker.with(ProfileImageActivity.this)
                        .crop()	    			// Crop image (Optional)
                        		// Final image size will be less than 1 MB (Optional)
                        .maxResultSize(1080, 1080)	// Final image resolution will be less than 1080 x 1080 (Optional)
                        .start();               // Start the image picker
            }
        });
    }

    // Handle the result after image selection or camera capture
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if the result is valid
        if (data != null && resultCode == RESULT_OK) {
            // Get the URI of the selected image
            selectedImageUri = data.getData();

            // Display the selected image in img ImageView
            if (selectedImageUri != null) {
                img.setImageURI(selectedImageUri);
            }
        } else {
            // If no image is selected, show a Toast message
            Toast.makeText(ProfileImageActivity.this, "No image selected. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
