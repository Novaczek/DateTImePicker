package com.example.kalkulatorwieku;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Button btnConfirm;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        btnConfirm = findViewById(R.id.btnConfirm);
        result = findViewById(R.id.Result);

        btnConfirm.setOnClickListener(v->{
            ObliczWiek();
        });
    }

    private void ObliczWiek(){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        LocalDate dataUrodzenia = LocalDate.of(year,month+1,day);
        LocalDate aktualnaData = LocalDate.now();

        long wiek = ChronoUnit.YEARS.between(dataUrodzenia,aktualnaData);

        result.setText("Masz "+Long.toString(wiek)+" lat");
    }
}