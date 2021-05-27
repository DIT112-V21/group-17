    package com.example.android;
    import android.app.Dialog;
    import android.content.DialogInterface;
    import android.os.Bundle;

    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatDialogFragment;


        public class MessageDialog extends AppCompatDialogFragment {


            private String message;
            private String messageTitle;

            public MessageDialog(String messageTitle,String message){
                this.messageTitle=messageTitle;
                this.message=message;
            }

            public String getMessage() {
                return message;
            }


            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(messageTitle)

                        .setMessage(message)
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                return builder.create();
            }
        }