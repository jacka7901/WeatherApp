package com.jack.weatherapp;

import com.jack.weatherapp.models.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jack on 4/27/2016.
 */
public interface WeatherApiService {


    @GET("weather")
    Call<WeatherData>getWeatherByCoordinate(@Query("lat")double latitude, @Query("lon")double longitude);


    @GET("weather")
    Call<WeatherData>getWeatherByZipcode(@Query("zip")int zip);
}
