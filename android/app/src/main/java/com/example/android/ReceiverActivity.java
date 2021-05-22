package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        Button confirm = findViewById(R.id.receiver_messages);
        Button logout = findViewById(R.id.logout_button);

        confirm.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.receiver_messages:
                break;

            case R.id.logout_button:
                home();
                break;
        }
    }

    public void home() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}