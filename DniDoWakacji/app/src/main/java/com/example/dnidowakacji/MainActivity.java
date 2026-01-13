package com.example.dnidowakacji;

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
    private TextView result;

    private Button btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        result = findViewById(R.id.Result);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(v->{
            SprawdzIleDni();
        });
    }

    private void SprawdzIleDni(){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        LocalDate wybranaData = LocalDate.of(year, month + 1, day);
        LocalDate aktualnaData = LocalDate.now();

        if(ChronoUnit.DAYS.between(aktualnaData, wybranaData) < 0){
            result.setText("Ta data już minęła!");
        } else if (ChronoUnit.DAYS.between(aktualnaData, wybranaData) > 0) {
            result.setText("Pozostało "+Long.toString(ChronoUnit.DAYS.between(aktualnaData, wybranaData))+" dni");
        }

    }
}