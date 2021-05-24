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

public class ReceiverMessageListAdapter extends ArrayAdapter<Message> {

    private static final String TAG = "ReceiverMessageListAdapter";

    private Context mContext;
    private int mResource;


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public ReceiverMessageListAdapter(Context context, int resource, ArrayList<Message> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

    }

    ArrayList<Message> messages=Controller.receiverMessageList();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        Message message=messages.get(position);
        //String mailmanId=messages.get(position).getSenderID();
        String mailmanName=messages.get(position).getSender();
        Receiver currentReceiver = Controller.getLoggedInReceiver();
        Mailman mailman=Controller.searchMailManById(messages.get(position).getSenderID());



        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvMessage = (TextView) convertView.findViewById(R.id.tv_receiver_message);
        Button confirm = (Button) convertView.findViewById(R.id.confirmbutton);


        tvMessage.setText(message.getContent());

       confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String confirm_sent = "pick-up confirmation message sent to "+mailmanName;


                Log.w(TAG,confirm_sent );
                Toast.makeText(mContext.getApplicationContext(), confirm_sent, Toast.LENGTH_SHORT).show();

                Controller.confirmPickupMessage(mailman,currentReceiver);

            }
        });


        return convertView;
    }
}