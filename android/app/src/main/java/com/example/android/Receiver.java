package com.example.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Receiver extends AppCompatActivity {
    private Button bttn;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;
    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Button bttn = (Button) findViewById(R.id.notificationbttn);
        final TextView tvSelectedItemsPreview = findViewById(R.id.selectedItemPreview);
        // initialise the list items for the alert dialog
        final String[] listItems = new String[]{"Package 1", "Package 2", "Package 3", "Package 4"};
        final boolean[] checkedItems = new boolean[listItems.length];

        // copy the items from the main list to the selected item list
        // for the preview if the item is checked then only the item
        // should be displayed for the user
        final List<String> selectedItems = Arrays.asList(listItems);

        // handle the Open Alert Dialog button
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initially set the null for the text preview
                tvSelectedItemsPreview.setText(null);

                // initialise the alert dialog builder
                AlertDialog.Builder builder = new AlertDialog.Builder(Receiver.this);

                // set the title for the alert dialog
                builder.setTitle("Your Deliveries");

                // set the icon for the alert dialog
                builder.setIcon(R.drawable.logo);

                // now this is the function which sets the alert dialog for multiple item selection ready
                builder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                        String currentItem = selectedItems.get(which);
                    }
                });

                // alert dialog shouldn't be cancellable
                builder.setCancelable(false);

                // handle the positive button of the dialog
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            if (checkedItems[i]) {
                                tvSelectedItemsPreview.setText(tvSelectedItemsPreview.getText() + selectedItems.get(i) + ", ");
                            }
                        }
                    }
                });

                // handle the negative button of the alert dialog
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


                // create the builder
                builder.create();
                // create the alert dialog with the
                // alert dialog builder instance
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}









