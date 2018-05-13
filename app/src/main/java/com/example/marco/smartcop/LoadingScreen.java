package com.example.marco.smartcop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoadingScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
    }

    public void fingerPrintReader(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
