package com.example.android;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverListActivity extends AppCompatActivity {

    private static final String TAG = "ReceiverListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_list);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);


        ReceiverListAdapter adapter = new ReceiverListAdapter(this, R.layout.adapter_receiver_list_view_layout, Controller.receiversList);
        mListView.setAdapter(adapter);
    }
}