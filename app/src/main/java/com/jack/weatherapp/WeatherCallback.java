package com.jack.weatherapp;

import com.jack.weatherapp.models.ForecastWeatherData;
import com.jack.weatherapp.models.WeatherData;

/**
 * Created by jack on 4/28/2016.
 */
public interface WeatherCallback {
    void weatherDownloadCompleted(boolean success, WeatherData WeatherData);
    

}
