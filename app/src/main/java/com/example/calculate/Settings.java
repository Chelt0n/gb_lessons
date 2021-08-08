package com.example.calculate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Settings extends AppCompatActivity  {
    final static int whiteTheme = 1;
    final static int blackTheme = 2;
    Button back;
    RadioButton whiteButton;
    RadioButton blackButton;
    static final String KEY_SP = "sp";
    static final String KEY_CURRENT_THEME = "current_theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getRealStyle(getCurrentTheme()));
        setContentView(R.layout.activity_settings);
        back = findViewById(R.id.back);
        whiteButton = findViewById(R.id.whiteTheme);
        blackButton = findViewById(R.id.blackTheme);
        Intent goBack = new Intent(this, MainMenu.class);
        switch (getCurrentTheme()) {
            case 1:
                whiteButton.setChecked(true);
                break;
            case 2:
                blackButton.setChecked(true);
                break;
        }
        whiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrentTheme(whiteTheme);
                recreate();
            }
        });
        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrentTheme(blackTheme);
                recreate();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goBack);
            }
        });



    }

    private void setCurrentTheme(int currentTheme) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_CURRENT_THEME, currentTheme);
        editor.apply();
    }

    private int getCurrentTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        return (sharedPreferences.getInt(KEY_CURRENT_THEME, -1));
    }
    private int getRealStyle(int currentTheme) {
        switch (currentTheme) {
            case whiteTheme:
                return R.style.whiteTheme;
            case blackTheme:
                return R.style.blackTheme;

            default:
                return 0;
        }
    }

}