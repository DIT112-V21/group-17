package com.example.android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MailmanMessageListAdapter extends ArrayAdapter<Message> {

    private static final String TAG = "MailmanMessageListAdapter";
    private static int position;

    private Context mContext;
    private int mResource;


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
        String name = getItem(position).getSenderName();
        String senderID = message.getSenderID();
        String mailmanID=Controller.getLoggedInMailmanID();


        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvMessage = (TextView) convertView.findViewById(R.id.tv_mailman_message);
        Button pickup = (Button) convertView.findViewById(R.id.pickup_button);
        String message_title=message.getSenderName()+" "+message.getTitle();

        tvMessage.setText(message_title);

        if(message.getTitle().equals("Available")) {
            pickup.setVisibility(Button.VISIBLE);
            if(!message.getMessageStatus().equals("sent")) {
                pickup.setEnabled(true);


                pickup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String pickup_sent = "pick-up delivery message sent to " + name;
                        Controller.sendPickupMessage(mailmanID, senderID);

                        pickup.setEnabled(false);
                        message.setMessageStatus("sent");

                        Log.w(TAG, pickup_sent);
                        Toast.makeText(mContext.getApplicationContext(), pickup_sent, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }



        return convertView;
    }
}