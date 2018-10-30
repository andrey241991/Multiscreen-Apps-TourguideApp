package com.example.home_pc.tourguideapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    private String name;
    private String description;
    private int image;

    public Place(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    protected Place(Parcel in) {
        name = in.readString();
        description = in.readString();
        image = in.readInt();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(image);
    }
}
