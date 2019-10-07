package com.example.admin.dbmsproject;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.admin.dbmsproject.Extra.HomeRecyclerAdapter;
import com.example.admin.dbmsproject.Extra.R_ItemClickListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    HomeRecyclerAdapter rAdapter;
    LinearLayout planYourDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeStatusBarColor();
        initToolbar();
        initDrawer();
        initRecycler();

        planYourDay = (LinearLayout) findViewById(R.id.plan_your_day);
        planYourDay.setOnClickListener(this);

        DBHandler db = new DBHandler(this);
        db.insertData();
        db.close();

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
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */

        ImageView button_search = (ImageView) findViewById(R.id.button_search);
        button_search.setOnClickListener(this);

        ImageView nav_button = (ImageView) findViewById(R.id.nav_button);
        nav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    private void initDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
        navigationView.addHeaderView(header);
    }

    private void initRecycler(){

        RecyclerView r_list = (RecyclerView) findViewById(R.id.home_recycler);
        rAdapter = new HomeRecyclerAdapter(this);
        if (r_list != null) {

            r_list.setAdapter(rAdapter);
            GridLayoutManager glm = new GridLayoutManager(this, 3/*Number of Columns*/);
            r_list.setLayoutManager(glm);

            r_list.addOnItemTouchListener(
                    new R_ItemClickListener(getApplicationContext(), r_list,new R_ItemClickListener.OnItemClickListener() {

                        @Override
                        public void onItemClick(View view, int position) {
                            onRecyclerItemPressed(position);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));
        }
    }

    public void onRecyclerItemPressed(int position){

        Intent intent = new Intent(this, AllOption.class);
        intent.putExtra("Position", position);
        startActivity(intent);

    }//onRecyclerItemPressed()

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button_search){
            Intent i = new Intent(this, Search.class);
            startActivity(i);
        }

        if(v.getId() == R.id.plan_your_day){
            Intent i = new Intent(this, PlanYourDay.class);
            startActivity(i);
        }

    }//onClick()

}//Main Activity
