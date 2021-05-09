package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
//MQTT connection part of the code is built on https://github.com/DIT112-V21/smartcar-mqtt-controller.git

public class ManualActivity extends AppCompatActivity implements View.OnClickListener {
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
        MqttBackgroundProcess mqtt = new MqttBackgroundProcess();
        switch (v.getId()) {
            case R.id.Forward:
                mqtt.forward();
                break;
            case R.id.Left:
                mqtt.left();
                break;
            case R.id.Stop:
                mqtt.stop();
                break;
            case R.id.Right:
                mqtt.right();
                break;
            case R.id.Backward:
                mqtt.backward();
                break;
        }
    }
}