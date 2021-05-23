package com.example.android;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MailmanMessageListActivity extends AppCompatActivity {

    private static final String TAG = "MailmanMessageListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailman_message_list);

        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listViewMailmanMessageList);


        MailmanMessageListAdapter adapter = new MailmanMessageListAdapter(this, R.layout.adapter_mailman_message_list_view_layout, Controller.mailmanMessageList());
        mListView.setAdapter(adapter);
    }
}