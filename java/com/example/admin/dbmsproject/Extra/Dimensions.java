package com.example.admin.dbmsproject.Extra;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Sahil Jain on 10-04-2018.
 */

public abstract class Dimensions {

    static Display display;

    public static  float getPixelWidth(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        display = wm.getDefaultDisplay();
        int display_width = display.getWidth();

        return display_width;
    }
    public static float getPixelHeight(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        display = wm.getDefaultDisplay();
        int display_height = display.getHeight();

        return display_height;
    }

    public static float getDensity(Context context)
    {
        float Density;

        Density = context.getResources().getDisplayMetrics().density;

        return  Density;
    }
}
