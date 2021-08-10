package com.example.calculate;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button calculate;
    Button settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getRealStyle(getCurrentTheme()));
        setContentView(R.layout.activity_menu);
        calculate = findViewById(R.id.calculate);
        settings = findViewById(R.id.settings);
        Intent goToCalculate = new Intent("runCalculate");
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

    private int getCurrentTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(Settings.KEY_SP, MODE_PRIVATE);
        return (sharedPreferences.getInt(Settings.KEY_CURRENT_THEME, -1));
    }

    private int getRealStyle(int currentTheme) {
        switch (currentTheme) {
            case Settings.whiteTheme:
                return R.style.whiteTheme;
            case Settings.blackTheme:
                return R.style.blackTheme;

            default:
                return 0;
        }
    }

}