package com.example.sprawdzeniegodzinyotwarcia;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private Button btnCheck;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);
        btnCheck = findViewById(R.id.btnCheck);
        info = findViewById(R.id.Info);

        btnCheck.setOnClickListener(v->{
            Sprawdz();
        });
    }
    private void Sprawdz(){
        LocalTime  godzinaOtwarcia = LocalTime.of(8,0);
        LocalTime  godzinaZamkniecia = LocalTime.of(16,0);
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        LocalTime wybranaGodzina = LocalTime.of(hour, minute);

        if(wybranaGodzina.isAfter(godzinaOtwarcia) &&  wybranaGodzina.isBefore(godzinaZamkniecia)){
            info.setText("Otwarte, zapraszamy!");
        }else{
            info.setText("Zamknięte!!");
        }

    }
}