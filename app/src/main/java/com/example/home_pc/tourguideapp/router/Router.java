package com.example.home_pc.tourguideapp.router;

import android.content.Context;
import android.content.Intent;

import com.example.home_pc.tourguideapp.DetailedActivity;
import com.example.home_pc.tourguideapp.entity.Place;

import static com.example.home_pc.tourguideapp.DetailedActivity.PLACE_KEY;

public class Router {

    public static void startDetailedActivity(Context context, Place place){
        Intent intent = new Intent(context, DetailedActivity.class);
        intent.putExtra(PLACE_KEY, place);
        context.startActivity(intent);
    }
}
