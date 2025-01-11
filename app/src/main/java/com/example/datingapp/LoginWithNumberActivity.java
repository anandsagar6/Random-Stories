package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginWithNumberActivity extends AppCompatActivity {
    EditText mobileNumber;
    Button getOtpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_with_number);
        mobileNumber = findViewById(R.id.input_mobile_number);
        getOtpBtn = findViewById(R.id.buttongetotp);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String mobile = mobileNumber.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){

                    Toast.makeText(LoginWithNumberActivity.this, "Please Enter Your Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(LoginWithNumberActivity.this, OtpActivity.class);
                    intent.putExtra("mobile", mobile);
                    startActivity(intent);
                }
            }
        });
    }
}