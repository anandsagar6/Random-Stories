package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LastNameActivity extends AppCompatActivity {
    Button lastBtn;
    EditText LastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_last_name);

        lastBtn = findViewById(R.id.lastbtn);
        LastName = findViewById(R.id.LastName);

        lastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lastName = LastName.getText().toString().trim();
                if(lastName.isEmpty()){
                    Toast.makeText(LastNameActivity.this, "Please Enter Your Last Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(LastNameActivity.this,DOBActivity.class);
                    startActivity(i);
                    i.putExtra(lastName,"lastName");
                }
            }
        });
    }
}