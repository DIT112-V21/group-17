package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManualActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        Button forward_button = findViewById(R.id.forward_manual);
        Button backwards_button = findViewById(R.id.backwards_manual);
        Button left_button = findViewById(R.id.left_manual);
        Button right_button = findViewById(R.id.right_manual);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        forward_button.setOnClickListener(this);
        backwards_button.setOnClickListener(this);
        left_button.setOnClickListener(this);
        right_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                break;
            case R.id.stop:
                break;
            case R.id.forward_manual:
                break;
            case R.id.backwards_manual:
                break;
            case R.id.left_manual:
                break;
            case R.id.right_manual:
                break;
        }
    }
}