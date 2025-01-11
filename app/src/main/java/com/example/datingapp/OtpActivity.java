package com.example.datingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OtpActivity extends AppCompatActivity {

    TextView showmobile;
    String mobile;
    EditText input1,input2,input3,input4,input5,input6;
   Button getOtpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);
        showmobile = findViewById(R.id.textmobileshownumber);

        input1 = findViewById(R.id.inputotp1);
        input2 = findViewById(R.id.inputotp2);
        input3 = findViewById(R.id.inputotp3);
        input4 = findViewById(R.id.inputotp4);
        input5 = findViewById(R.id.inputotp5);
        input6 = findViewById(R.id.inputotp6);
        getOtpBtn = findViewById(R.id.buttongetotp);


        mobile = getIntent().getStringExtra("mobile");

         showmobile.setText(mobile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String i1=input1.getText().toString().trim();
                String i2=input2.getText().toString().trim();
                String i3=input3.getText().toString().trim();
                String i4=input4.getText().toString().trim();
                String i5=input5.getText().toString().trim();
                String i6=input6.getText().toString().trim();

                if(i1.isEmpty() ||i2.isEmpty() || i3.isEmpty() || i4.isEmpty() || i5.isEmpty() || i6.isEmpty()){
                    Toast.makeText(OtpActivity.this, "Enter the OTP", Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(OtpActivity.this,PermissionActivity.class));
                }


            }
        });


        NumberOtpMove();

    }


    private void  NumberOtpMove(){
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()){
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()){
                    input3.requestFocus();
                }
                else if (s.toString().trim().isEmpty()) {
                    input1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()){
                    input4.requestFocus();
                }
                else if (s.toString().trim().isEmpty()) {
                    input2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()){
                    input5.requestFocus();
                }
                else if (s.toString().trim().isEmpty()) {
                    input3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()){
                    input6.requestFocus();
                }
                else if (s.toString().trim().isEmpty()) {
                    input4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (s.toString().trim().isEmpty()) {
                    input5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }



}