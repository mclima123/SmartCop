package com.example.marco.smartcop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Call extends AppCompatActivity
{
    private int seconds = 0;
    private int minutes = 0;
    private String m, s;
    private ImageView micro;
    private ImageView speaker;
    private int state_micro = 0;
    private int state_speaker = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        TextView t_1 = findViewById(R.id.textView3);
        TextView t_2 = findViewById(R.id.textView16);
        String s = getIntent().getStringExtra("button_clicked");
        String new_t_1;
        String new_t_2;
        micro = findViewById(R.id.imageView8);
        speaker = findViewById(R.id.imageView9);

        switch(s){
            case "fire_dpt":
                new_t_1 = t_1.getText() + " - Fire Dpt.";
                new_t_2 = "Fire Department";
                break;
            case "hq":
                new_t_1 = t_1.getText() + " - Headquarters";
                new_t_2 = "Headquarters";
                break;
            case "ambulance":
                new_t_1 = t_1.getText() + " - Ambulance";
                new_t_2 = "Ambulance";
                break;
            default:
                new_t_1 = "Call";
                new_t_2 = "Call";
                break;
        }

        t_1.setText(new_t_1);
        t_2.setText(new_t_2);

        //Declare the timer
        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        TextView tv = findViewById(R.id.textView17);
                        tv.setText(formatTime(minutes, seconds));
                        seconds += 1;

                        if(seconds == 60){
                            minutes++;
                            seconds = 0;
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    public void clickEndCall(View view) {
        finish();
    }

    public String formatTime(int min, int sec){
        m = String.valueOf(min);
        s = String.valueOf(sec);

        if(m.length() == 1){
            m = "0" + m;
        }
        if(s.length() == 1){
            s = "0" + s;
        }

        return m + ":" + s;
    }

    public void clickMicrophone(View view){
        if(state_micro == 0){
            state_micro = 1;
            micro.setImageResource(R.mipmap.unmute_micro_foreground);
        }
        else{
            state_micro = 0;
            micro.setImageResource(R.mipmap.mute_micro_foreground);
        }
    }

    public void clickSpeaker(View view){
        if(state_speaker == 0){
            state_speaker = 1;
            speaker.setImageResource(R.mipmap.unmute_speaker_foreground);
        }
        else{
            state_speaker = 0;
            speaker.setImageResource(R.mipmap.mute_speaker_foreground);
        }
    }
}
