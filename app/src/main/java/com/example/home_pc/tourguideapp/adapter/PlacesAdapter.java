package com.example.home_pc.tourguideapp.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home_pc.tourguideapp.OnItemClick;
import com.example.home_pc.tourguideapp.R;
import com.example.home_pc.tourguideapp.entity.Place;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

   private ArrayList<Place> places;
    private OnItemClick onItemClick;

    public PlacesAdapter(ArrayList<Place> places) {
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.place_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void setOnItemClick(OnItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title) TextView txtTitle;
        @BindView(R.id.txt_description) TextView txtDescription;
        @BindView(R.id.image) ImageView image;
        @BindView(R.id.root_layout) ConstraintLayout rootLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootLayout.setOnClickListener(v -> onItemClick.onItemClick(places.get(getAdapterPosition())));
        }

        public void bind(int position) {
            Place currentPlace = places.get(position);
            txtTitle.setText(currentPlace.getName());
            txtDescription.setText(currentPlace.getDescription());
            image.setImageResource(currentPlace.getImage());
        }
    }
}
