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
                boolean verify=Controller.verifyMailmanCredentials(username, password);
                if(verify==true) {
                    add_information();
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    final String wrongCredM = "Wrong credentials to login as a mailman!\n Try again!";
                    Log.w(TAG, wrongCredM);
                    Toast.makeText(getApplicationContext(), wrongCredM, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.receiver_button:
                boolean verify2=Controller.verifyReceiverCredentials(username, password);
                if(verify2==true) {
                    add_information();
                    Intent intentq = new Intent(this, ReceiverActivity.class);
                    startActivity(intentq);
                }
                else{
                    final String wrongCredR = "Wrong credentials to login as receiver!\n Try again!";
                    Log.w(TAG, wrongCredR);
                    Toast.makeText(getApplicationContext(), wrongCredR, Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }


    public void add_information() {
        Log.d("username", username);
        Log.d("password", password);
    }
}