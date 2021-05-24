package com.example.android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MailmanMessageListAdapter extends ArrayAdapter<Message> {

    private static final String TAG = "MailmanMessageListAdapter";

    private Context mContext;
    private int mResource;


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public MailmanMessageListAdapter(Context context, int resource, ArrayList<Message> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    ArrayList<Message> messages=Controller.mailmanMessageList();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.w(TAG,"message view started" );

        Message message=messages.get(position);


        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvMessage = (TextView) convertView.findViewById(R.id.tv_mailman_message);
        String message_title=message.getSenderName()+" "+message.getTitle();


        tvMessage.setText(message_title);



        return convertView;
    }
}