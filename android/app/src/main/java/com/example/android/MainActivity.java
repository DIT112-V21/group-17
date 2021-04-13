package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_button = findViewById(R.id.login_button);
        Button signup_button = findViewById(R.id.signup_button);

        login_button.setOnClickListener(this);
        signup_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                openLogin();
                break;
            case R.id.signup_button:
                openSignup();
                break;
        }
    }

    public void openLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void openSignup() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}