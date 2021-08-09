package com.example.calculate;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static String TAG = "Counters";

    TextView textView;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Counters counters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getRealStyle(getCurrentTheme()));
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        counters = new Counters();

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


    private int getCurrentTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(Settings.KEY_SP, MODE_PRIVATE);
        return (sharedPreferences.getInt(Settings.KEY_CURRENT_THEME, -1));
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        counters = (Counters) instanceState.getSerializable(TAG);
        setTextCounters();
    }

    private void setTextCounters() {
        textView.setText(counters.getCount());

    }

    private void initListener() {
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
    }

    private void initView() {
        textView = findViewById(R.id.textView);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.zero:
                counters.setCount(0);
                textView.setText(counters.getCount());
                break;
            case R.id.one:
                counters.setCount(1);
                textView.setText(counters.getCount());
                break;
            case R.id.two:
                counters.setCount(2);
                textView.setText(counters.getCount());
                break;
            case R.id.three:
                counters.setCount(3);
                textView.setText(counters.getCount());
                break;
            case R.id.four:
                counters.setCount(4);
                textView.setText(counters.getCount());
                break;
            case R.id.five:
                counters.setCount(5);
                textView.setText(counters.getCount());
                break;
            case R.id.six:
                counters.setCount(6);
                textView.setText(counters.getCount());
                break;
            case R.id.seven:
                counters.setCount(7);
                textView.setText(counters.getCount());
                break;
            case R.id.eight:
                counters.setCount(8);
                textView.setText(counters.getCount());
                break;
            case R.id.nine:
                counters.setCount(9);
                textView.setText(counters.getCount());
                break;
            default:
                break;


        }


    }

}



