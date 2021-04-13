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
    EditText usernameInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView usernameInput = findViewById(R.id.input_username);
        TextView passwordInput = findViewById(R.id.input_password);
        Button submit_button = findViewById(R.id.submit_button);
        submit_button.hasOnClickListeners();
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
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        Log.d("username", username);
        Log.d("password", password);

    }
}