package com.jack.weatherapp.models;
import com.google.gson.annotations.SerializedName;


/**
 * Created by jack on 5/3/2016.
 */
public class ForecastWeatherDetails {
    @SerializedName("temp")private double temperature;
    private double pressure;
    private double humidity;
    @SerializedName("temp_min") private double minTemperature;
    @SerializedName("temp_max")private double maxTemperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }




}
