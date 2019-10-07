package com.example.admin.dbmsproject.Extra;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sahil Jain on 10-04-2018.
 */

public class TourAdapter extends FragmentPagerAdapter {

    private int mCount = 4;
    // Initialize Adapter
    public TourAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {         // returns the type of item to be shown
        return new PlaceSlideFragment(position);

    }

    @Override
    public int getCount() {
        return mCount;
    } // return the count of items
}