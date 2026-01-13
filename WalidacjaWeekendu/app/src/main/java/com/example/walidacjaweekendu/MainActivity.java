package com.example.walidacjaweekendu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class MainActivity extends AppCompatActivity {
    private Button btnConfirm;
    private TextView info;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnConfirm = findViewById(R.id.btnConfirm);
        info = findViewById(R.id.Info);
        datePicker = findViewById(R.id.datePicker);

        btnConfirm.setOnClickListener(v->{
            weekend();
        });
    }
    private void weekend() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth(); // 0–11
        int year = datePicker.getYear();

        LocalDate wybranaData = LocalDate.of(year, month + 1, day);
        DayOfWeek dzien = wybranaData.getDayOfWeek();

        if (dzien == DayOfWeek.SATURDAY || dzien == DayOfWeek.SUNDAY) {
            info.setText("W weekendy nie przyjmujemy rezerwacji!");
        }else{
            info.setText("rezerwacji!");
        }
    }

}