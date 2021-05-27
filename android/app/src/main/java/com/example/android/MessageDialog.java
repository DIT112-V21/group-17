    package com.example.android;
    import android.app.Dialog;
    import android.content.DialogInterface;
    import android.os.Bundle;

    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatDialogFragment;


        public class MessageDialog extends AppCompatDialogFragment {


            private String message;

            public MessageDialog(String messages){
                this.message=message;
            }

            public String getMessage() {
                return message;
            }



            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Message details")

                        .setMessage("hi")
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                return builder.create();
            }
        }