package com.example.home_pc.tourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home_pc.tourguideapp.adapter.PlacesAdapter;
import com.example.home_pc.tourguideapp.entity.Place;
import com.example.home_pc.tourguideapp.router.Router;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends Fragment implements OnItemClick {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ArrayList<Place> places;

    public PlacesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            places = getArguments().getParcelableArrayList("key");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        PlacesAdapter adapter = new PlacesAdapter(places);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClick(this);
    }

    public static PlacesFragment newInstance(Bundle bundle) {
        PlacesFragment fragment = new PlacesFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onItemClick(Place place) {
        Router.startDetailedActivity(requireActivity(), place);
    }
}
