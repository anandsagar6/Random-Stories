package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class OnSingleTapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_on_single_tap);

        // Bind views
        ImageButton likeButton = findViewById(R.id.right_button);
        ImageButton complimentButton = findViewById(R.id.left_button);
        LottieAnimationView heartAnimation = findViewById(R.id.Like);
        ImageView crossImg = findViewById(R.id.cross_img);

        // Set the animation initially invisible
        heartAnimation.setVisibility(View.INVISIBLE);

        // Handle back navigation
        crossImg.setOnClickListener(v -> onBackPressed());

        // Load animation and adjust speed
        Animation heartPop = AnimationUtils.loadAnimation(this, R.anim.heart_pop);
        heartPop.setDuration((long) (heartPop.getDuration() / 1)); // Speed up animation by 2.5x

        // Like button click listener
        likeButton.setOnClickListener(view -> {
            // Show and start the animation
            heartAnimation.setVisibility(View.VISIBLE);
            heartAnimation.startAnimation(heartPop);

            // Animation listener
            heartPop.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    // Hide the animation after it ends
                    heartAnimation.setVisibility(View.INVISIBLE);

                    // Navigate to DashboardActivity
                    Intent intent = new Intent(OnSingleTapActivity.this, DashBoardActivity.class);
                    startActivity(intent);
                    finish(); // Optionally close this activity
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        });

        // Compliment button click listener
        complimentButton.setOnClickListener(v ->
                startActivity(new Intent(OnSingleTapActivity.this, WriteComplimentActivity.class))
        );
    }

    @Override
    public void onBackPressed() {
        // Navigate to DashboardActivity on back press
        super.onBackPressed();
        startActivity(new Intent(OnSingleTapActivity.this, DashBoardActivity.class));
    }
}
