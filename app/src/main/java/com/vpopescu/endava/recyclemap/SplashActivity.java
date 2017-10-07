package com.vpopescu.endava.recyclemap;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = (ProgressBar) findViewById(R.id.progressBarOnStart);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#C0D000"), android.graphics.PorterDuff.Mode.SRC_ATOP);

        Thread logoTimer = new Thread(){
            public void run(){
                try{
                    int logoTimer = 0;
                    while (logoTimer<5000){
                        sleep(100);
                        logoTimer=logoTimer+100;
                    }
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally{
                    finish();
                }
            }
        };
        logoTimer.start();
    }

}
