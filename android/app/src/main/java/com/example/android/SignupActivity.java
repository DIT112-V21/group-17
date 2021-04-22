package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    String username, password, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText usernameInput = findViewById(R.id.input_username);
        EditText passwordInput = findViewById(R.id.input_password);
        EditText emailInput = findViewById(R.id.input_email);
        username = usernameInput.getText().toString();
        password = passwordInput.getText().toString();
        email = emailInput.getText().toString();
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
        Log.d("email", email);
    }
}