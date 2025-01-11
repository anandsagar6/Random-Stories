package com.example.datingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerifyAgeActivity extends AppCompatActivity {

    String age;
    TextView txt;
    Button yesBtn,noBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_age);
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);

        txt = findViewById(R.id.age);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int year = 2024;
        int dob=0;
        age = getIntent().getStringExtra("age");
        int ageNumber=Integer.parseInt(age);
        if(ageNumber == year){
            dob=1;
        }
        else {
        dob = year - ageNumber;
        }

            txt.setText("You're "+dob + " ?");

        if(dob < 18){
            yesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(VerifyAgeActivity.this, "Sorry! Your are not above 18...", Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            yesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   startActivity(new Intent(VerifyAgeActivity.this,GenderActivity.class));
                }
            });
        }

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerifyAgeActivity.this,DOBActivity.class));
            }
        });


    }
}