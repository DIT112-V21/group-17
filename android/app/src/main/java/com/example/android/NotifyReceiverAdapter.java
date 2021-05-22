package com.example.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NotifyReceiverAdapter extends ArrayAdapter<Receiver> {

    private static final String TAG = "NotifyReceiverAdapter";

    private Context mContext;
    private int mResource;
    private Mailman mailman=Controller.mailmenList.get(0);


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public NotifyReceiverAdapter(Context context, int resource, ArrayList<Receiver> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getName();
        Receiver receiver=getItem(position);


        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvName = (TextView) convertView.findViewById(R.id.textview4);
        Button expect = (Button) convertView.findViewById(R.id.expect_button);
        Button pickup = (Button) convertView.findViewById(R.id.pickup_button);

        tvName.setText(name);

        expect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.sendExpectDelivery(mailman,receiver);

            }
        });

        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.sendPickupMessage(mailman,receiver);
            }
        });




        return convertView;
    }
}