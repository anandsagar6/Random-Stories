package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GenderActivity extends AppCompatActivity {

    private ImageView maleImage, femaleImage;
    private Button nxt;
    private String selectedGender = "Please Select Gender"; // Default gender

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        maleImage = findViewById(R.id.male_img);
        femaleImage = findViewById(R.id.female_img);
        nxt = findViewById(R.id.next);

        maleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedGender = "male";
                maleImage.setBackgroundResource(R.drawable.gender_img_selected_background);
                femaleImage.setBackgroundResource(R.drawable.gender_img_background); // Reset female
                Toast.makeText(GenderActivity.this, "Male selected", Toast.LENGTH_SHORT).show();
            }
        });

        femaleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedGender = "female";
                femaleImage.setBackgroundResource(R.drawable.gender_img_selected_background);
                maleImage.setBackgroundResource(R.drawable.gender_img_background); // Reset male
                Toast.makeText(GenderActivity.this, "Female selected", Toast.LENGTH_SHORT).show();
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedGender != "male" && selectedGender != "female"){
                    Toast.makeText(GenderActivity.this, selectedGender, Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(GenderActivity.this, ProfileImageActivity.class);
                    intent.putExtra("gender", selectedGender); // Pass selected gender
                    startActivity(intent);
                }

            }
        });
    }
}
