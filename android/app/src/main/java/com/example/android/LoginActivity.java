package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText usernameInput = findViewById(R.id.input_username);
        EditText passwordInput = findViewById(R.id.input_password);
        username = usernameInput.getText().toString();
        password = passwordInput.getText().toString();
        Button mailman_button = findViewById(R.id.mailman_button);
        mailman_button.setOnClickListener(this);
        Button receiver_button = findViewById(R.id.receiver_button);
        receiver_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mailman_button:
                add_information();
                Intent intent = new Intent(this, ManualActivity.class);
                startActivity(intent);
                break;
            case R.id.receiver_button:
                add_information();
                Intent intentq = new Intent(this, Receiver.class);
                startActivity(intentq);
                break;
        }

    }


    public void add_information() {
        Log.d("username", username);
        Log.d("password", password);
    }
}