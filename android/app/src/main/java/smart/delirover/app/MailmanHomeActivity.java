package smart.delirover.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.delirover.app.R;


public class MailmanHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MailmanHome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button manual_button = findViewById(R.id.manual_button);
        Button notify_button = findViewById(R.id.notify_button);//to send notification in a list
        Button logout = findViewById(R.id.logout_button);
        Button receiver_list_button = findViewById(R.id.receiver_list_button);
        Button traveleddistance_button = findViewById(R.id.traveleddistance_button);
        Button mailman_message_list_button = findViewById(R.id.mailman_message_list_button);


        manual_button.setOnClickListener(this);
        receiver_list_button.setOnClickListener(this);
        notify_button.setOnClickListener(this);
        logout.setOnClickListener(this);
        mailman_message_list_button.setOnClickListener(this);
        traveleddistance_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.manual_button:
                Intent intent = new Intent(this, ManualActivity.class);
                startActivity(intent);
                break;
            case R.id.receiver_list_button:
                Intent intentz = new Intent(this, ReceiverListActivity.class);
                startActivity(intentz);
                break;
            case R.id.notify_button:
                Intent intent2 = new Intent(this, NotifyReceiverActivity.class);
                startActivity(intent2);
                break;
            case R.id.mailman_message_list_button:
                Intent intent3 = new Intent(this, MailmanMessageListActivity.class);
                startActivity(intent3);
                break;
            case R.id.traveleddistance_button:
                Intent intent4 = new Intent(this, MailmanTraveledDistanceActivity.class);
                startActivity(intent4);
                break;
            case R.id.logout_button:
                Controller.mailmanLogOut();
                Intent intenty = new Intent(this, LoginActivity.class);
                startActivity(intenty);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        final String noBack = "You need to log out first!";
        Log.w(TAG, noBack);
        Toast.makeText(getApplicationContext(), noBack, Toast.LENGTH_SHORT).show();

        return;
    }
}
