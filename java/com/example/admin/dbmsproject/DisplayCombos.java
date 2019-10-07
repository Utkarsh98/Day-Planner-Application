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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayCombos extends AppCompatActivity {

    int numPeople, range;
    int rangeLow = 500, rangeHigh = 1000;
    String[][] data;
    int val1 = 0;
    int val2 = 6;
    int val3 = 13;
    int val4 = 24;

    TextView movie1, restaurant1, touristPlace1, cost1;
    TextView movie2, restaurant2, touristPlace2, cost2;
    TextView movie3, restaurant3, touristPlace3, cost3;
    TextView movie4, restaurant4, touristPlace4, cost4;
    LinearLayout lin1, lin2, lin3, lin4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_combos);

        changeStatusBarColor();
        initToolbar();
        initLinearLayouts();
        initVariables();

        Intent intent = getIntent();
        numPeople = intent.getIntExtra("Num People", 2);
        range = intent.getIntExtra("Range", 1);

        switch(range){
            case 1: rangeLow = 500; rangeHigh = 1000; break;
            case 2: rangeLow = 1000; rangeHigh = 1500; break;
            case 3: rangeLow = 1500; rangeHigh = 2500; break;
        }

        setValues();

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

    private void initLinearLayouts(){

        lin1 = (LinearLayout) findViewById(R.id.lin_combo1);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] info = new String[3][4];

                info[0][0] = data[0][val1];
                info[0][1] = data[1][val1];
                info[0][2] = data[2][val1];
                info[0][3] = data[3][val1];

                info[1][0] = data[4][val1];
                info[1][1] = data[5][val1];
                info[1][2] = data[6][val1];

                info[2][0] = data[7][val1];
                info[2][1] = data[8][val1];
                info[2][2] = data[9][val1];
                info[2][3] = data[10][val1];

                Intent intent = new Intent(getApplicationContext(), SelectedCombo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Selected_Info", info);
                intent.putExtras(bundle);
                intent.putExtra("numPeople", numPeople);
                startActivity(intent);
            }
        });

        lin2 = (LinearLayout) findViewById(R.id.lin_combo2);
        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] info = new String[3][4];

                info[0][0] = data[0][val2];
                info[0][1] = data[1][val2];
                info[0][2] = data[2][val2];
                info[0][3] = data[3][val2];

                info[1][0] = data[4][val2];
                info[1][1] = data[5][val2];
                info[1][2] = data[6][val2];

                info[2][0] = data[7][val2];
                info[2][1] = data[8][val2];
                info[2][2] = data[9][val2];
                info[2][3] = data[10][val2];

                Intent intent = new Intent(getApplicationContext(), SelectedCombo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Selected_Info", info);
                intent.putExtras(bundle);
                intent.putExtra("numPeople", numPeople);
                startActivity(intent);
            }
        });

        lin3 = (LinearLayout) findViewById(R.id.lin_combo3);
        lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] info = new String[3][4];

                info[0][0] = data[0][val3];
                info[0][1] = data[1][val3];
                info[0][2] = data[2][val3];
                info[0][3] = data[3][val3];

                info[1][0] = data[4][val3];
                info[1][1] = data[5][val3];
                info[1][2] = data[6][val3];

                info[2][0] = data[7][val3];
                info[2][1] = data[8][val3];
                info[2][2] = data[9][val3];
                info[2][3] = data[10][val3];

                Intent intent = new Intent(getApplicationContext(), SelectedCombo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Selected_Info", info);
                intent.putExtras(bundle);
                intent.putExtra("numPeople", numPeople);
                startActivity(intent);
            }
        });

        lin4 = (LinearLayout) findViewById(R.id.lin_combo4);
        lin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] info = new String[3][4];

                info[0][0] = data[0][val4];
                info[0][1] = data[1][val4];
                info[0][2] = data[2][val4];
                info[0][3] = data[3][val4];

                info[1][0] = data[4][val4];
                info[1][1] = data[5][val4];
                info[1][2] = data[6][val4];

                info[2][0] = data[7][val4];
                info[2][1] = data[8][val4];
                info[2][2] = data[9][val4];
                info[2][3] = data[10][val4];

                Intent intent = new Intent(getApplicationContext(), SelectedCombo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Selected_Info", info);
                intent.putExtras(bundle);
                intent.putExtra("numPeople", numPeople);
                startActivity(intent);
            }
        });
    }

    private void initVariables(){

        movie1 = (TextView) findViewById(R.id.option1_movie);
        restaurant1 = (TextView) findViewById(R.id.option1_restaurant);
        touristPlace1 = (TextView) findViewById(R.id.option1_tourist_place);
        cost1 = (TextView) findViewById(R.id.option1_cost);

        movie2 = (TextView) findViewById(R.id.option2_movie);
        restaurant2 = (TextView) findViewById(R.id.option2_restaurant);
        touristPlace2 = (TextView) findViewById(R.id.option2_tourist_place);
        cost2 = (TextView) findViewById(R.id.option2_cost);

        movie3 = (TextView) findViewById(R.id.option3_movie);
        restaurant3 = (TextView) findViewById(R.id.option3_restaurant);
        touristPlace3 = (TextView) findViewById(R.id.option3_tourist_place);
        cost3 = (TextView) findViewById(R.id.option3_cost);

        movie4 = (TextView) findViewById(R.id.option4_movie);
        restaurant4 = (TextView) findViewById(R.id.option4_restaurant);
        touristPlace4 = (TextView) findViewById(R.id.option4_tourist_place);
        cost4 = (TextView) findViewById(R.id.option4_cost);
    }

    private void setValues(){

        DBHandler db = new DBHandler(this);
        data = db.getAllData(rangeLow - 500, rangeHigh - 500);
        db.close();

        movie1.setText(data[0][val1]);
        touristPlace1.setText(data[4][val1]);
        restaurant1.setText(data[7][val1]);
        Integer totalCost1 = numPeople * (Integer.valueOf(data[1][val1]) + Integer.valueOf(data[5][val1]) + Integer.valueOf(data[8][val1]));
        String temp = "Rs. " + totalCost1;
        cost1.setText(temp);

        movie2.setText(data[0][val2]);
        touristPlace2.setText(data[4][val2]);
        restaurant2.setText(data[7][val2]);
        Integer totalCost2 = numPeople * (Integer.valueOf(data[1][val2]) + Integer.valueOf(data[5][val2]) + Integer.valueOf(data[8][val2]));
        temp = "Rs. " + totalCost2;
        cost2.setText(temp);

        movie3.setText(data[0][val3]);
        touristPlace3.setText(data[4][val3]);
        restaurant3.setText(data[7][val3]);
        Integer totalCost3 = numPeople * (Integer.valueOf(data[1][val3]) + Integer.valueOf(data[5][val3]) + Integer.valueOf(data[8][val3]));
        temp = "Rs. " + totalCost3;
        cost3.setText(temp);

        movie4.setText(data[0][val4]);
        touristPlace4.setText(data[4][val4]);
        restaurant4.setText(data[7][val4]);
        Integer totalCost4 = numPeople * (Integer.valueOf(data[1][val4]) + Integer.valueOf(data[5][val4]) + Integer.valueOf(data[8][val4]));
        temp = "Rs. " + totalCost4;
        cost4.setText(temp);

    }//setValues()

}//Activity
