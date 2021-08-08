package com.example.calculate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button calculate;
    Button settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        calculate = findViewById(R.id.calculate);
        settings = findViewById(R.id.settings);
        Intent goToCalculate = new Intent(this, MainActivity.class);
        Intent goToSettings = new Intent(this, Settings.class);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToCalculate);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToSettings);
            }
        });


    }

}