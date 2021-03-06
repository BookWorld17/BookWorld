package com.example.bookapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertManager {

    private Activity context = null;

    public AlertManager(){}

    public AlertManager(Activity context){
        this.context =  context;
    }

    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        if(status != null)
            alertDialog.setIcon((status) ? R.drawable.true_icon: R.drawable.false_icon);
            alertDialog.setButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }

    public void showAlertDialog(Context context, String title, String message, Boolean status, DialogInterface.OnClickListener okListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        if(status != null)
            alertDialog.setIcon((status) ? R.drawable.true_icon: R.drawable.false_icon);
        alertDialog.setButton(context.getString(R.string.ok), okListener);
        alertDialog.show();
    }


    public void showAAddCartSucess(Context context, String title, String message
            , DialogInterface.OnClickListener contListener
            , DialogInterface.OnClickListener placeListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon(  R.drawable.true_icon);
        alertDialog.setButton(context.getString(R.string.cont_shopping), contListener);
        alertDialog.setButton2(context.getString(R.string.place_order), placeListener);
        alertDialog.show();
    }


    public void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.ok), okListener)
                .setNegativeButton(context.getString(R.string.Cancel), null)
                .create()
                .show();
    }


}
