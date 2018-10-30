package com.example.home_pc.tourguideapp.util;

import com.example.home_pc.tourguideapp.R;
import com.example.home_pc.tourguideapp.entity.Place;

import java.util.ArrayList;

public class PlaceGeneratorHelper {

    public static ArrayList<Place> getParks(){
        ArrayList places = new ArrayList();
        places.add(new Place("Парк 50 летия", "Парка в Сосновке", R.drawable.img_park_fifteen));
        places.add(new Place("Парк 30 летия", "Парк в ЮЗР", R.drawable.img_park_thorteen));
        places.add(new Place("Парк Долина Роз", "Парк на Мытнице", R.drawable.img_park_dolina));
        return places;
    }

    public static ArrayList<Place> getCafe(){
        ArrayList places = new ArrayList();
        places.add(new Place("Faro", "Ресторан на Мытницк", R.drawable.img_faro));
        places.add(new Place("Coffeine", "Кафешка возле ЧНУ", R.drawable.img_cofeein));
        places.add(new Place("Буба", "Ресторан грузинской кухни", R.drawable.img_buba));
        return places;

    }

    public static ArrayList<Place> getCinema(){
        ArrayList places = new ArrayList();
        places.add(new Place("Кинотеатр Украина", "Кинотеатр в центре города", R.drawable.img_cinem_uraine));
        places.add(new Place("Кинотеатр Мультиплекс Днипро Плаза", "Кинотеатр в ТРЦ Днипро Плаза", R.drawable.img_dneproplaza));
        places.add(new Place("Кинотеатр Мультиплекс Любава", "Кинотеатр в ТРЦ Любава", R.drawable.img_lubava));
        return places;
    }
}
