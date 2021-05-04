package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManualActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        Button forward = findViewById(R.id.Forward);
        Button left = findViewById(R.id.Left);
        Button stop = findViewById(R.id.Stop);
        Button right = findViewById(R.id.Right);
        Button backward = findViewById(R.id.Backward);

        forward.setOnClickListener(this);
        left.setOnClickListener(this);
        stop.setOnClickListener(this);
        right.setOnClickListener(this);
        backward.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Forward:
                drive(MOVEMENT_SPEED, STRAIGHT_ANGLE, "Moving forward");
                break;
            case R.id.Left:
                drive(MOVEMENT_SPEED, -STEERING_ANGLE, "Moving forward left");
                break;
            case R.id.Stop:
                drive(IDLE_SPEED, STRAIGHT_ANGLE, "Stopping");
                break;
            case R.id.Right:
                drive(MOVEMENT_SPEED, STEERING_ANGLE, "Moving forward left");
                break;
            case R.id.Backward:
                drive(-MOVEMENT_SPEED, STRAIGHT_ANGLE, "Moving backward");
                break;
        }
    }
}