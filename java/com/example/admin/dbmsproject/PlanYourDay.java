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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlanYourDay extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linR1, linR2, linR3;
    ImageView imgR1, imgR2, imgR3;
    EditText numPeople;
    TextView submitButton;
    private int range = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_your_day);

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
    }

    private void initVariables(){

        linR1 = (LinearLayout) findViewById(R.id.linear_range_1);
        linR1.setOnClickListener(this);
        linR2 = (LinearLayout) findViewById(R.id.linear_range_2);
        linR2.setOnClickListener(this);
        linR3 = (LinearLayout) findViewById(R.id.linear_range_3);
        linR3.setOnClickListener(this);

        imgR1 = (ImageView) findViewById(R.id.img_range_1);
        imgR2 = (ImageView) findViewById(R.id.img_range_2);
        imgR3 = (ImageView) findViewById(R.id.img_range_3);

        numPeople = (EditText) findViewById(R.id.et_num_people);
        submitButton = (TextView) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);

    }//initVariables()

    private void submit(){

        if(range!=0){
            if(numPeople.getText()!=null) {
                String value = numPeople.getText().toString();
                int num = 0;

                try {
                    num = Integer.parseInt(value);
                }
                catch(Exception e){
                    Toast.makeText(this, "Please Enter Number of People between 1-10.", Toast.LENGTH_SHORT).show();
                }

                if (num > 0 && num <= 10) {
                    Intent intent = new Intent(this, DisplayCombos.class);
                    intent.putExtra("Num People", num);
                    intent.putExtra("Range", range);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(this, "Please Enter Number of People between 1-10.", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "Please Enter Number of People", Toast.LENGTH_SHORT).show();
            }//if et not null
        }//if range
        else{
            Toast.makeText(this, "Please Select a Budget Range.", Toast.LENGTH_SHORT).show();
        }

    }//submit()

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.submit_button){
            submit();
        }

        if(v.getId() == R.id.linear_range_1){
            imgR1.setImageResource(R.drawable.ic_check_box_black_24dp);
            imgR2.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            imgR3.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            range = 1;
        }
        if(v.getId() == R.id.linear_range_2){
            imgR1.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            imgR2.setImageResource(R.drawable.ic_check_box_black_24dp);
            imgR3.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            range = 2;
        }
        if(v.getId() == R.id.linear_range_3){
            imgR1.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            imgR2.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            imgR3.setImageResource(R.drawable.ic_check_box_black_24dp);
            range = 3;
        }

    }//onClick()

}//Activity
