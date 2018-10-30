package com.example.home_pc.tourguideapp.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.home_pc.tourguideapp.util.PlaceGeneratorHelper;
import com.example.home_pc.tourguideapp.PlacesFragment;

public class PlacesPagerAdapter extends FragmentPagerAdapter {

    public static final int PARKS_TAB_POSITION = 0;
    public static final int CAFE_TAB_POSITION = 1;
    public static final int HISTORICAL_PLACE_TAB_POSITION = 2;


    public PlacesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        switch (position) {
            case PARKS_TAB_POSITION:
                args.putParcelableArrayList("key", PlaceGeneratorHelper.getParks());
                return PlacesFragment.newInstance(args);
            case CAFE_TAB_POSITION:
                args.putParcelableArrayList("key", PlaceGeneratorHelper.getCafe());
                return PlacesFragment.newInstance(args);
            case HISTORICAL_PLACE_TAB_POSITION:
                args.putParcelableArrayList("key", PlaceGeneratorHelper.getCinema());
                return PlacesFragment.newInstance(args);
        }
        return PlacesFragment.newInstance(args);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case PARKS_TAB_POSITION:
                return "Парки";
            case CAFE_TAB_POSITION:
                return "Кафе";
            case HISTORICAL_PLACE_TAB_POSITION:
                return "Кинотеатры";
            default:
                return "Парки";
        }
    }

}
