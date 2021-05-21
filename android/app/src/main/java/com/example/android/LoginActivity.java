package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Login";
    String username, password;
    EditText usernameInput;
    EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInput = (EditText) findViewById(R.id.input_username);
        passwordInput = (EditText) findViewById(R.id.input_password);
        Button mailman_button = findViewById(R.id.mailman_button);
        mailman_button.setOnClickListener(this);
        Button receiver_button = findViewById(R.id.receiver_button);
        receiver_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        username = usernameInput.getText().toString();
        password = passwordInput.getText().toString();
        switch (v.getId()){
            case R.id.mailman_button:
                
                if((username.equals("mailman")) && (password.equals("123"))) {
                    add_information();
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    final String wrongpassword = "Wrong password! Try again!";
                    Log.w(TAG, wrongpassword);
                    Toast.makeText(getApplicationContext(), wrongpassword, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.receiver_button:
                add_information();
                Intent intentq = new Intent(this, ReceiverActivity.class);
                startActivity(intentq);
                break;
        }

    }


    public void add_information() {
        Log.d("username", username);
        Log.d("password", password);
    }
}