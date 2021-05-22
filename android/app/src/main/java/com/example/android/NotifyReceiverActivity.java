package com.example.android;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class NotifyReceiverActivity extends AppCompatActivity {

    private static final String TAG = "NotifyReceiverActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_receiver);

        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listViewNotify);


        NotifyReceiverAdapter adapter = new NotifyReceiverAdapter(this, R.layout.adapter_notify_receiver_list_view_layout, Controller.receiversList);
        mListView.setAdapter(adapter);
    }
}