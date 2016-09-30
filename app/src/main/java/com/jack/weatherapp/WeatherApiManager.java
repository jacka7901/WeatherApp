package com.jack.weatherapp;

/**
 * Created by jack on 4/27/2016.
 */

import com.jack.weatherapp.models.ForecastWeatherData;
import com.jack.weatherapp.models.WeatherData;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiManager {

    private static final String API_KEY = "fae94be3e77f0cb6fe9cc965e957b750";
    private WeatherApiService service;




    public WeatherApiManager(){

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter("units","imperial").addQueryParameter("appid", API_KEY).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        }).build();

//is this ok?

        Retrofit currentRetroFit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = currentRetroFit.create(WeatherApiService.class);

//        Retrofit futureRetroFit = new Retrofit.Builder()
//                .baseUrl("http://api.openweathermap.org/data/2.5/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
////??
//
//        this.service = futureRetroFit.create(WeatherApiService.class);



    }


    public void getWeatherByCoordinate(double latitude, double longitude, final WeatherCallback weatherCallback){
        this.service.getWeatherByCoordinate(latitude,longitude).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, retrofit2.Response<WeatherData> response) {
                weatherCallback.weatherDownloadCompleted(true, response.body());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                weatherCallback.weatherDownloadCompleted(false, null);

            }
        });

    }


    public void getWeatherByZipcode(int zip,final WeatherCallback weatherCallback){
        this.service.getWeatherByZipcode(zip).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                weatherCallback.weatherDownloadCompleted(true, response.body());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                weatherCallback.weatherDownloadCompleted(false, null);
            }
        });

    }
}
