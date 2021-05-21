package com.example.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 3/14/2017.
 */

public class ReceiverListAdapter extends ArrayAdapter<Receiver> {

    private static final String TAG = "ReceiverListAdapter";

    private Context mContext;
    private int mResource;


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
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
        String password=getItem(position).getPassWord();

        //Create the person object with the information
        Receiver person = new Receiver(name,password,address);

       LayoutInflater inflater=LayoutInflater.from(mContext);
       convertView=inflater.inflate(mResource,parent,false);
       TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
       TextView tvID = (TextView) convertView.findViewById(R.id.textView2);
       TextView tvAddress = (TextView) convertView.findViewById(R.id.textView3);


       tvName.setText(name);
       tvID.setText(ID);
       tvAddress.setText(address);


        return convertView;
    }
}