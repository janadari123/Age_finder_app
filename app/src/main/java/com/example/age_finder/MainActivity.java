package com.example.age_finder;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBirthdate;
    private TextView textViewAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBirthdate = findViewById(R.id.editTextBirthdate);
        textViewAge = findViewById(R.id.textViewAge);
    }

    public void calculateAge(View view) {
        String inputDate = editTextBirthdate.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        try {
            Date birthDate = sdf.parse(inputDate);
            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(birthDate);

            Calendar todayCalendar = Calendar.getInstance();

            int age = todayCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

            if (todayCalendar.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }

            textViewAge.setText("Age: " + age);
        } catch (ParseException e) {
            textViewAge.setText("Invalid Date Format");
        }
    }
}
