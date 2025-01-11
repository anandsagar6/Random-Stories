package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class PlansActivity extends AppCompatActivity {
    private ImageView cross_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        cross_img = findViewById(R.id.cross_img);

        // Set click listener for cross_img
        cross_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlansActivity.this, DashBoardActivity.class);
                startActivity(intent);

                // Apply zoom-out animation for activity transition
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Apply zoom-out animation for back press
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
    }
}
