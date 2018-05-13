package com.example.marco.smartcop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickSettings(View view){
        Intent intent = new Intent(this, SettingsMenu.class);
        startActivity(intent);
    }

    public void clickIdentify(View view){
        Intent intent = new Intent(this, IdentifyMenu.class);
        startActivity(intent);
    }

    public void clickInformation(View view){
        Intent intent = new Intent(this, InformationMenu.class);
        startActivity(intent);
    }

    public void clickContacts(View view){
        Intent intent = new Intent(this, ContactsMenu.class);
        startActivity(intent);
    }

    public void clickFileReport(View view){
        Intent intent = new Intent(this, FileReport.class);
        startActivity(intent);
    }

    public void clickID(View view){
        android.support.v7.app.AlertDialog diaBox = AskOption(); //mostra a opção de Eliminar
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
}
