package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class WriteComplimentActivity extends AppCompatActivity {
    Button sendBtn;
    EditText compliment;
    ImageView crossBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_write_compliment);

        sendBtn = findViewById(R.id.sendBtn);
        compliment = findViewById(R.id.compliment);
        crossBtn = findViewById(R.id.cross_img);

        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WriteComplimentActivity.this,OnSingleTapActivity.class));
            }
        });

        compliment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Enable or disable the send button based on whether there's text
                sendBtn.setEnabled(s.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (compliment.getText().toString().length() > 0) {
                    startActivity(new Intent(WriteComplimentActivity.this, DashBoardActivity.class));
                    Toast.makeText(WriteComplimentActivity.this, "Send", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WriteComplimentActivity.this, "Write a Compliment First...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Disable the send button initially
        sendBtn.setEnabled(false);
    }
}
