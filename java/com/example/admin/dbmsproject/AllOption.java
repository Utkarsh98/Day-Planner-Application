package com.example.admin.dbmsproject;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.dbmsproject.Extra.RAdapter;

public class AllOption extends AppCompatActivity {

    int val = 0;
    int MAX_VAL = 10;
    int searchVal = 0;
    TextView heading;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_option);

        changeStatusBarColor();
        initToolbar();

        Intent i = getIntent();
        val = i.getIntExtra("Position", MAX_VAL);
        String text = new String();
        switch (val){
            case 0: text = "Restaurants";  break;
            case 1: text = "Movies";  break;
            case 2: text = "Tourist Places";  break;
            default: text = "Restaurants";  break;
        }

        if (val == MAX_VAL){
            searchVal = i.getIntExtra("Search_value", 20);
            text = "Search";
        }

        Log.d("ABCD - val", String.valueOf(val));
        Log.d("ABCD - searchVal", String.valueOf(searchVal));

        heading = (TextView) findViewById(R.id.toolbar_text);
        heading.setText(text);

        initRecycler();

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
    }

    private void initRecycler(){
        recyclerView = (RecyclerView) findViewById(R.id.all_options_recycler);
        if (recyclerView != null) {

            Log.d("ABCD - Fn Val", String.valueOf(val));

            if (val == MAX_VAL){
                recyclerView.setAdapter(new RAdapter(this, searchVal));
            }
            else {
                recyclerView.setAdapter(new RAdapter(this, val));
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }
    }//initRecycler()

}//AllOptions Class
