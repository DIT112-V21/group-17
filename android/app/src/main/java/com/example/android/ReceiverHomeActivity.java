package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ReceiverHome";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        Button receiver_message_list = findViewById(R.id.receiver_message_list);
        Button logout = findViewById(R.id.logout_button);

        receiver_message_list.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.receiver_message_list:
            Intent intent = new Intent(this, ReceiverMessageListActivity.class);
            startActivity(intent);
            break;

            case R.id.logout_button:
                Controller.receiverLogOut();
                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        final String noBack = "You need to log out first!";
        Log.w(TAG, noBack);
        Toast.makeText(getApplicationContext(), noBack, Toast.LENGTH_SHORT).show();

        return;
    }
}