package com.example.datingapp;

import android.annotation.SuppressLint;
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

public class FirstNameActivity extends AppCompatActivity {
    Button firstBtn;
    EditText firstName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_name);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstBtn = findViewById(R.id.firstbtn);
        firstName = findViewById(R.id.firstName);


        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = firstName.getText().toString().trim();
                if(firstname.isEmpty()){
                    Toast.makeText(FirstNameActivity.this, "Please Enter Your First Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(FirstNameActivity.this,LastNameActivity.class);
                    startActivity(i);
                    i.putExtra(firstname,"firstName");



                }
            }
        });


    }
}