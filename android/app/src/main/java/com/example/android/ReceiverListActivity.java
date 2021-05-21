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
        setContentView(R.layout.activity_receiver);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        Controller.addReceiver("Leila","123"," room 1");
        Controller.addReceiver("Sven","123"," room 2");
        Controller.addReceiver("Maab","123"," room 3");
        Controller.addReceiver("Sofia","123"," room 4");
        Controller.addReceiver("Elif","123"," room 5");
        Controller.addReceiver("Cui","123"," room 6");
        Controller.addReceiver("Receiver_1","123"," room 7");
        Controller.addReceiver("Receiver_1","123"," room 8");
        Controller.addReceiver("Receiver_1","123"," room 9");
        Controller.addReceiver("Receiver_1","123"," room 10");
        Controller.addReceiver("Receiver_1","123"," room 11");
        Controller.addReceiver("Receiver_1","123"," room 12");
        Controller.addReceiver("Receiver_1","123"," room 13");
        Controller.addReceiver("Receiver_1","123"," room 14");
        Controller.addReceiver("Receiver_1","123"," room 15");
        Controller.addReceiver("Receiver_1","123"," room 16");
        Controller.addReceiver("Receiver_1","123"," room 17");
        Controller.addReceiver("Receiver_1","123"," room 18");

        ReceiverListAdapter adapter = new ReceiverListAdapter(this, R.layout.activity_receiver_list, Controller.receiversList);
        mListView.setAdapter(adapter);
    }
}