package com.jack.weatherapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jack on 4/28/2016.
 */
public class Coordinate {
    @SerializedName("lat")private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @SerializedName("lon") private double longitude;


}
