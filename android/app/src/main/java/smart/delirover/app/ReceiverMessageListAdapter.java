package smart.delirover.app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.delirover.app.R;

import java.util.ArrayList;

public class ReceiverMessageListAdapter extends ArrayAdapter<Message> {

    private static final String TAG = "ReceiverMessageListAdapter";

    private Context mContext;
    private int mResource;

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
        String mailmanId=messages.get(position).getSenderID();
        String mailmanName=messages.get(position).getSenderName();
        Receiver currentReceiver = Controller.getLoggedInReceiver();
        Mailman mailman=Controller.mailmanFromID(messages.get(position).getSenderID());



        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvMessage = (TextView) convertView.findViewById(R.id.tv_receiver_message);
        Button confirm = (Button) convertView.findViewById(R.id.confirmbutton);
        Button available=(Button) convertView.findViewById(R.id.available) ;
        Button notAvailable=(Button) convertView.findViewById(R.id.not_available);


        tvMessage.setText(message.getTitle());


        if(message.getTitle().equals("Confirm pick-up")){

            confirm.setVisibility(Button.VISIBLE);
            if(!message.getMessageStatus().equals("sent")){
                confirm.setEnabled(true);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String confirm_sent = "pick-up confirmation message sent to "+mailmanName;
                        Controller.confirmPickupMessage(mailman,currentReceiver);
                        Log.w(TAG,confirm_sent );
                        Toast.makeText(mContext.getApplicationContext(), confirm_sent, Toast.LENGTH_SHORT).show();

                        confirm.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
                        confirm.setEnabled(false);
                        message.setMessageStatus("sent");

                    }
                });
            }
        }

        if(message.getTitle().equals("Expect")){

            available.setVisibility(Button.VISIBLE);
            notAvailable.setVisibility(Button.VISIBLE);

            if(!message.getMessageStatus().equals("sent")){

                available.setEnabled(true);
                notAvailable.setEnabled(true);

                available.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String available_sent = "Confirmation message sent to "+mailmanName;
                        Controller.available(mailman,currentReceiver);
                        Log.w(TAG,available_sent );
                        Toast.makeText(mContext.getApplicationContext(), available_sent, Toast.LENGTH_SHORT).show();


                        available.setEnabled(false);
                        notAvailable.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
                        notAvailable.setEnabled(false);
                        message.setMessageStatus("sent");

                    }
                });

                notAvailable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String not_available_sent = "Message sent to "+mailmanName;
                        Controller.notAvailable(mailman,currentReceiver);
                        Log.w(TAG,not_available_sent );
                        Toast.makeText(mContext.getApplicationContext(), not_available_sent, Toast.LENGTH_SHORT).show();


                        available.setEnabled(false);
                        available.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
                        notAvailable.setEnabled(false);
                        message.setMessageStatus("sent");

                    }
                });
            }
        }

       return convertView;
    }

}