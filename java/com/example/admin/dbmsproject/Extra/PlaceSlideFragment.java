package com.example.admin.dbmsproject.Extra;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.dbmsproject.R;

/**
 * Created by Sahil Jain on 10-04-2018.
 */

public final class PlaceSlideFragment extends Fragment {

    private String[] TourLine = new String[] {"Get your daily dose of what's new and trending in your city",
            "Enjoy a personalised feed based on your own interests",
            "Receive recommendations from hand picked local experts",
            "Bookmark, share with friends and make the most of your city!"
    };
    private int[] Image = new int[] {R.drawable.ob1,R.drawable.ob2,R.drawable.ob3, R.drawable.ob4};
    private int Position;

    Context context;
    public PlaceSlideFragment() {

    }

    @SuppressLint("ValidFragment")
    public PlaceSlideFragment( int position) { // Initialize page according to the position no.

        Position = position; // Getting the position no.
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        // Creating relative layout
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        relativeLayout.setGravity(Gravity.CENTER);

        // Creating Textview for tagline
        TextView tagline = new TextView(getActivity());

        // Creating Imgeview for Background Images
        ImageView imageView = new ImageView(getActivity());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)); // Setting layoutparams to image
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // Setting the scale type to images


        // Initializing layout params for tagline
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        tagline.setLayoutParams(lp);                                // applying layout params to taglinetext
        tagline.setGravity(Gravity.CENTER);                         // set gravity for tagline
        tagline.setText(TourLine[Position]);                        // set Text of tagline accoring to position
        tagline.setTextColor(Color.WHITE);                          // set text color of tagline
        tagline.setTextSize(getTextSize());                              // Applying text size according to screen size
        tagline.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);          // setting text alignment
        tagline.setShadowLayer(10, 2, 2, Color.BLACK);                  // Setting shadow color and size to text of tagline
        tagline.setPadding(60, 0, 60, 0);                               // setting padding to tagline
        tagline.setLines(3);                                        // set maximun lines to taglines


        imageView.setImageResource(Image[Position]); // Setting images according to position of page


        // creating global layout for page
        RelativeLayout layout = new RelativeLayout(getActivity());
        layout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);

        // Adding images and taglines to layout
        relativeLayout.addView(imageView);
        relativeLayout.addView(tagline);
        layout.addView(relativeLayout);


        return layout;  //return layout to show
    }

    private float getTextSize() {       // defining the text size according to screen size

        float textSize;

        float Density = Dimensions.getDensity(context); // Initialize Density of screen
        float PixelWidth  = Dimensions.getPixelWidth(context); // Initializing Screen Width of Screen

        // Setting the size
        float dpWidth = PixelWidth/Density;
        if(dpWidth < 240 )
            textSize = 15.0F;
        else if (dpWidth < 400 && dpWidth > 240)
            textSize = 20.0F;
        else
            textSize = 35.0F;

        return textSize;    // return textsize
    }
}