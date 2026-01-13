package com.example.rezerwacja;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Button btnConfirm;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        btnConfirm = findViewById(R.id.btnConfirm);
        info = findViewById(R.id.Info);

        btnConfirm.setOnClickListener(v->{
            Rezerwacja();
        });
    }

    private void Rezerwacja(){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth(); // Uwaga: zwraca 0-11
        int year = datePicker.getYear();

        // 2. Pobranie danych z TimePicker
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();


        LocalDate wybranaData = LocalDate.of(year, month + 1, day);
        LocalTime wybranaGodzina = LocalTime.of(hour, minute);

        LocalDateTime wybranaDataRezerwacji = LocalDateTime.of(wybranaData,wybranaGodzina);
        LocalDateTime tearz = LocalDateTime.now();


        if(wybranaDataRezerwacji.isBefore(tearz)){
            info.setText("nie mozna dokonac rezerwacji w tym terminie!!");
            info.setTextColor(R.color.red);
        } else if (wybranaDataRezerwacji.isAfter(tearz)) {
            info.setText("rezerwacja poszła pomyślnie!!");
            info.setTextColor(R.color.red);
        }
    }
}