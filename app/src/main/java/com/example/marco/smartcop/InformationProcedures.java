package com.example.marco.smartcop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InformationProcedures extends SwipeDismissBaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_procedures);
    }

    public void clickID(View view){
        android.support.v7.app.AlertDialog diaBox = AskOption();
        diaBox.show();
    }

    private android.support.v7.app.AlertDialog AskOption()
    {
        android.support.v7.app.AlertDialog myQuittingDialogBox = new android.support.v7.app.AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Logout?")

                //"Confirm" button
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        Intent intent = new Intent(getApplicationContext(), LoadingScreen.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                        dialog.dismiss();
                    }
                })

                //Cancel button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;
    }

    public void clickAmbulance(View view){
        Intent intent = new Intent(this, Call.class);
        intent.putExtra("button_clicked", "ambulance");
        startActivity(intent);
    }

    public void clickProcedure(View view) {
        android.support.v7.app.AlertDialog diaBox = ProcedurePopUp();
        diaBox.show();
    }

    private android.support.v7.app.AlertDialog ProcedurePopUp()
    {
        android.support.v7.app.AlertDialog myQuittingDialogBox = new android.support.v7.app.AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Steps")

                .setMessage("1 - Example step\n2 - Example step\n3 - Example step\n4 - Example step")

                .create();
        return myQuittingDialogBox;
    }
}
