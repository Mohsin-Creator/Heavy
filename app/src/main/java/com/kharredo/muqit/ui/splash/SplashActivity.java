package com.kharredo.muqit.ui.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.kharredo.muqit.R;
import com.kharredo.muqit.ui.welcome.WelcomeActivity;

public class SplashActivity extends Activity {

    private static int splash_time_out=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        } ,2000);
    }
}
