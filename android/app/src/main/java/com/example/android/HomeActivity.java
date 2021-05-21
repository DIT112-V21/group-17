package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button manual_button = findViewById(R.id.manual_button);
        Button notification_button = findViewById(R.id.notification_button);
        Button confirmation_button = findViewById(R.id.confirmation_button);
      Button logout = findViewById(R.id.logout_button);

        Button receiver_list_button = findViewById(R.id.receiver_list_button);
        manual_button.setOnClickListener(this);
        notification_button.setOnClickListener(this);
        confirmation_button.setOnClickListener(this);
        receiver_list_button.setOnClickListener(this);
      logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.manual_button:
                Intent intent = new Intent(this, ManualActivity.class);
                startActivity(intent);
                break;
            
            case R.id.notification_button:
                Intent intentq = new Intent(this, ReceiverActivity.class);
                startActivity(intentq);
                break;
            
            case R.id.confirmation_button:
                Intent intentx = new Intent(this, PickupNotificationActivity.class);
                startActivity(intentx);

            case R.id.receiver_list_button:
                Intent intentz = new Intent(this, ReceiverListActivity.class);
                startActivity(intentz);
                break;
            
            case R.id.logout_button:
                Intent intenty = new Intent(this, LoginActivity.class);
                startActivity(intenty);
                break;

        }
    }
}
