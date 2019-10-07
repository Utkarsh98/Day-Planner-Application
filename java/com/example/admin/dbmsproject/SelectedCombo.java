package com.example.admin.dbmsproject;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SelectedCombo extends AppCompatActivity {

    TextView name1, name2, name3;
    TextView details1, details2, details3;
    TextView totalCost;
    TextView confirm;
    int numPeople = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_combo);

        changeStatusBarColor();
        initToolbar();
        initVariables();

        Intent intent = getIntent();
        numPeople = intent.getIntExtra("numPeople", 1);
        Bundle bundle = intent.getExtras();
        String[][] info = (String[][]) bundle.getSerializable("Selected_Info");

        name1.setText(info[2][0]);
        String temp = "Cuisine: " + info[2][2] + ", Rating: " + info[2][3];
        details1.setText(temp);

        name2.setText(info[0][0]);
        temp = "Genre: " + info[0][2] + ", Rating: " + info[0][3];
        details2.setText(temp);

        name3.setText(info[1][0]);
        temp = "Rating: " + info[1][2];
        details3.setText(temp);

        int cost = numPeople * (Integer.parseInt(info[0][1]) + Integer.parseInt(info[1][1]) + Integer.parseInt(info[2][1]));
        temp = "Total Cost: Rs." + cost;
        totalCost.setText(temp);

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

    private void initVariables(){

        name1 = (TextView) findViewById(R.id.res_name);
        details1 = (TextView) findViewById(R.id.res_deatils);

        name2 = (TextView) findViewById(R.id.movie_name);
        details2 = (TextView) findViewById(R.id.movie_deatils);

        name3 = (TextView) findViewById(R.id.tourist_place_name);
        details3 = (TextView) findViewById(R.id.tourist_place_deatils);

        totalCost = (TextView) findViewById(R.id.total_cost);
        confirm = (TextView) findViewById(R.id.selected_button);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your Selection has been Confirmed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}//SelectedCombo Class
