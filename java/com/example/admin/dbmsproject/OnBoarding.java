package com.example.admin.dbmsproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.dbmsproject.Extra.Dimensions;
import com.example.admin.dbmsproject.Extra.TourAdapter;
import com.example.admin.dbmsproject.Extra.ZoomOutPageTransformer;

public class OnBoarding extends AppCompatActivity {

    ViewPager Pager;
    TourAdapter Pageradapter;

    int mDotsCount;
    TextView[] mDotsText;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        context = getApplicationContext(); // Initializing the Context

        changeStatusBarColor();
        initContent();      // Initialize whole content of page

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

    private void initContent() {
        // Initialize screenlogo
        initlogo();
        // Initialize pager of images and text
        initPager();
        // Initialize Dotlayouts
        initDotLayouts();
    }

    private void initlogo() {

        // Creating LayoutParams for placing logo on correct position
        RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        float density = Dimensions.getDensity(context); // initialize density of screen
        int leftMargin = (int) ((Dimensions.getPixelWidth(context) - 100*density)/2); // initialize left margin
        int topMargin = (int) (Dimensions.getPixelHeight(context)/4 - 50*density);  // initialize right margin
        llp.setMargins(leftMargin, topMargin, 0, 0); // set margin to layoutparams
    }

    private void initPager() {
        // Initialize Pager of image scrolling
        Pager = (ViewPager) findViewById(R.id.BackgroundPics);
        // Initialize PagerAdapter
        Pageradapter =  new TourAdapter(getSupportFragmentManager());
        // Applying Adapter to pager
        Pager .setAdapter(Pageradapter);
        // Applying Page Transformation animation
        Pager .setPageTransformer(true, new ZoomOutPageTransformer());
        // Applying page listent to moving dots
        Pager.setOnPageChangeListener(new ViewpagerPageListener());

    }

    private void initDotLayouts() {

        LinearLayout mDotsLayout = ((LinearLayout)findViewById(R.id.dotsLayout)); // Initializing dotslayout

        mDotsCount = Pageradapter.getCount(); // Defining no. of Dots Count

        mDotsText = new TextView[this.mDotsCount];// Initializing Dots

        TextView getStarted = (TextView)findViewById(R.id.getstarted); // Initializing GetStarted Text

        getStarted.setOnTouchListener(new View.OnTouchListener() { // This function calls when Getstarted touched
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
                return false;
            }
        });



        //Initializing layoutparams for individual dots
        LinearLayout.LayoutParams llp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llp2.setMargins(20, 0, 0, 0);

        float textSize = 35.0F;

        float dpWidth = Dimensions.getPixelWidth(context)/Dimensions.getDensity(context); // Initializing Screen Width

        // Defining the Text size of Dots
        if(dpWidth < 240 )
            textSize = 25.0F;
        else if (dpWidth < 400 && Dimensions.getPixelWidth(context) > 240)
            textSize = 35.0F;
        else
            textSize = 50.0F;

        for (int i = 0; i < this.mDotsCount; i++)
        {
            mDotsText[i] = new TextView(this);
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(textSize); // Setting the text size of Dots
            mDotsText[i].setTextColor(Color.parseColor("#969ca0"));
            mDotsText[i].setLayoutParams(llp2);
            mDotsLayout.addView(mDotsText[i]);
        }

    }

    private class ViewpagerPageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // On page change Dots moved accroding to position
            for (int i = 0; i < mDotsCount; i++) {
                mDotsText[i].setTextColor(Color.parseColor("#969ca0"));
            }
            mDotsText[position].setTextColor(Color.WHITE);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }//ViewpagerPageListener Class

}//OnBoarding CLass
