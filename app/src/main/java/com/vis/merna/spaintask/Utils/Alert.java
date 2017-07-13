package com.vis.merna.spaintask.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.util.ArrayList;


public class Alert {

        private static String TAG = "TAG";
        public static void showErrorMsg(String title, String msg, Context context) {

            final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(msg);
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        }
        public static void showAlert(String title, String msg, ArrayList<DialogInterface.OnClickListener> clickListeners, ArrayList<String> btnName, ArrayList<Integer> btnTypes, Context context){
            final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(msg);

            Log.i(TAG, "Alert showAlert: btnName.size(): " + btnName.size());
            for (int i=0; i<clickListeners.size(); i++) {
                alertDialog.setButton(btnTypes.get(i), btnName.get(i), clickListeners.get(i));
            }

            alertDialog.show();
        }
}
