package smart.delirover.app;

import android.content.Context;
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

public class NotifyReceiverAdapter extends ArrayAdapter<Receiver> {

    private static final String TAG = "NotifyReceiverAdapter";

    private Context mContext;
    private int mResource;

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
        String mailmanID=Controller.getLoggedInMailmanID();


        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvName = (TextView) convertView.findViewById(R.id.textview4);
        Button expect = (Button) convertView.findViewById(R.id.expect_button);


        tvName.setText(name);

        expect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expect_sent = "Expect delivery message sent to "+name;
                Log.w(TAG,expect_sent );
                Toast.makeText(mContext.getApplicationContext(), expect_sent, Toast.LENGTH_SHORT).show();

                Controller.sendExpectDelivery(mailmanID,receiver);

            }
        });





        return convertView;
    }
}