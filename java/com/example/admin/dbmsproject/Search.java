package com.example.admin.dbmsproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Search extends AppCompatActivity implements View.OnClickListener {

    LinearLayout search1, search2, search3, search4, search5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        changeStatusBarColor();
        initToolbar();
        initVariables();

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

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView button_back = (ImageView) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EditText editText = (EditText) findViewById(R.id.search);

        Drawable ddd = getResources().getDrawable(R.drawable.ic_search_black_24dp);
        Drawable drawable = DrawableCompat.wrap(ddd);
        DrawableCompat.setTint(drawable, Color.WHITE);

        editText.setCompoundDrawablesWithIntrinsicBounds(drawable,null, null, null);
    }

    private void initVariables(){

        search1 = (LinearLayout) findViewById(R.id.search_trending);
        search1.setOnClickListener(this);
        search2 = (LinearLayout) findViewById(R.id.search_restaurants);
        search2.setOnClickListener(this);
        search3 = (LinearLayout) findViewById(R.id.search_movies);
        search3.setOnClickListener(this);
        search4 = (LinearLayout) findViewById(R.id.search_tourist_places);
        search4.setOnClickListener(this);
        search5 = (LinearLayout) findViewById(R.id.search_things_near_me);
        search5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.search_restaurants){
            Intent i = new Intent(this, AllOption.class);
            i.putExtra("Search_value", 0);
            startActivity(i);
        }
        if(v.getId() == R.id.search_movies){
            Intent i = new Intent(this, AllOption.class);
            i.putExtra("Search_value", 1);
            startActivity(i);
        }
        if(v.getId() == R.id.search_tourist_places){
            Intent i = new Intent(this, AllOption.class);
            i.putExtra("Search_value", 2);
            startActivity(i);
        }
        if(v.getId() == R.id.search_trending){
            Intent i = new Intent(this, AllOption.class);
            i.putExtra("Search_value", 20);
            startActivity(i);
        }
        if(v.getId() == R.id.search_things_near_me){
            Intent i = new Intent(this, AllOption.class);
            i.putExtra("Search_value", 21);
            startActivity(i);
        }

    }//onClick()

}//Search Activity
