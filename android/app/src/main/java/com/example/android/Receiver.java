package com.example.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Receiver extends AppCompatActivity implements View.OnClickListener {
    private Button bttn;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Button bttn = (Button) findViewById(R.id.notificationbttn);
        bttn.setOnClickListener( this);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notificationbttn:
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popwindow, null);
                popupWindow = new PopupWindow(container, 800,1000,true);
                popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, v.getWidth()/4,500);
        }
    }

}








