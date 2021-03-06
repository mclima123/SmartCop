package com.example.marco.smartcop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InformationMenu extends SwipeDismissBaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_menu);
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

    public void clickLaws(View view){
        Intent intent = new Intent(this, InformationLaws.class);
        startActivity(intent);
    }

    public void clickProcedures(View view){
        Intent intent = new Intent(this, InformationProcedures.class);
        startActivity(intent);
    }
}
