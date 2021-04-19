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

        Button connect_manual = findViewById(R.id.connect_manual);
        Button connect_automatic = findViewById(R.id.connect_automatic);
        Button emergency_break = findViewById(R.id.emergency_break);
        Button forward_button = findViewById(R.id.forward_manual);
        Button backwards_button = findViewById(R.id.backwards_manual);
        Button left_button = findViewById(R.id.left_manual);
        Button right_button = findViewById(R.id.right_manual);

        connect_manual.setOnClickListener(this);
        connect_automatic.setOnClickListener(this);
        emergency_break.setOnClickListener(this);
        forward_button.setOnClickListener(this);
        backwards_button.setOnClickListener(this);
        left_button.setOnClickListener(this);
        right_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.connect_manual:
                break;
            case R.id.connect_automatic:
                break;
            case R.id.emergency_break:
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