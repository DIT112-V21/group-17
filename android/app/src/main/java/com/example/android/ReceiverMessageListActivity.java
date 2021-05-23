package com.example.android;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverMessageListActivity extends AppCompatActivity {

    private static final String TAG = "ReceiverMessageListActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_message_list);

        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listViewReceiverMessageList);


        ReceiverMessageListAdapter adapter = new ReceiverMessageListAdapter(this, R.layout.adapter_receiver_message_list_view_layout, Controller.receiverMessageList());
        mListView.setAdapter(adapter);
    }
}