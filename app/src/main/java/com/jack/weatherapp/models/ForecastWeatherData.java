package com.jack.weatherapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jack on 5/4/2016.
 */
public class ForecastWeatherData {
    @SerializedName("coord") private Coordinate coordinate;
    @SerializedName("weather")private List<WeatherCondition> weatherConditions;
    private String base;

    @SerializedName("main") private WeatherDetails weatherDetails;
    private String name;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public List<WeatherCondition> getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(List<WeatherCondition> weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    public void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
