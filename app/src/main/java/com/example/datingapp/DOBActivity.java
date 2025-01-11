package com.example.datingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DOBActivity extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance();
    EditText DOB;
    Button DOBbtn;
    String selectedYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dob);

        DOB = findViewById(R.id.DOB);
        DOBbtn = findViewById(R.id.DOBnextBtn); // Initialize your button

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DOBActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        selectedYear = String.valueOf(year); // Store the year as a String

                        String myformat = "dd-MM-yyyy"; // Correct date format
                        SimpleDateFormat dateFormat = new SimpleDateFormat(myformat, Locale.US);
                        DOB.setText(dateFormat.format(myCalendar.getTime()));
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        DOBbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dob = DOB.getText().toString().trim();
                if(dob.isEmpty()){
                    Toast.makeText(DOBActivity.this, "Please Enter Your DOB", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Directly pass the selectedYear (no need to call getText)
                    Intent i = new Intent(DOBActivity.this, VerifyAgeActivity.class);
                    i.putExtra("age", selectedYear);
                    i.putExtra(dob,"dob");// Passing the selected year
                    startActivity(i);
                }
            }
        });
    }
}
