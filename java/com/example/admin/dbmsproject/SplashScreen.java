package com.example.admin.dbmsproject;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private TextView loading;
    private static int LOADING_TIME = 500;

    private static int SPLASH_TIME_OUT = 3100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        changeStatusBarColor();

        loading = (TextView) findViewById(R.id.splash_loading);
        loading.setText("Loading.");
        timer();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }//onCreate()

    private void changeStatusBarColor(){
        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        }
    }

    private void timer(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Loading.");
            }
        }, LOADING_TIME);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Loading. .");
            }
        }, LOADING_TIME * 2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Loading. . .");
            }
        }, LOADING_TIME * 3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Loading.");
            }
        }, LOADING_TIME * 4);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Loading. .");
            }
        }, LOADING_TIME * 5);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText("Loading. . .");
            }
        }, LOADING_TIME * 6);

    }//timer()

}//Splash Screen Activity
