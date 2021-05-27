package com.example.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ReceiverListAdapter extends ArrayAdapter<Receiver> {

    private static final String TAG = "ReceiverListAdapter";

    private Context mContext;
    private int mResource;

    public ReceiverListAdapter(Context context, int resource, ArrayList<Receiver> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getName();
        String ID = getItem(position).getID();
        String address = getItem(position).getAddress();

       LayoutInflater inflater=LayoutInflater.from(mContext);
       convertView=inflater.inflate(mResource,parent,false);
       TextView tvName = (TextView) convertView.findViewById(R.id.textview);
       TextView tvID = (TextView) convertView.findViewById(R.id.textView2);
       TextView tvAddress = (TextView) convertView.findViewById(R.id.textView3);


       tvName.setText(name);
       tvID.setText(ID);
       tvAddress.setText(address);


        return convertView;
    }
}