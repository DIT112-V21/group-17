package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

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
        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        add_information();
        openPost();
    }
    public void openPost() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void add_information() {
        Log.d("username", username);
        Log.d("password", password);
    }
}