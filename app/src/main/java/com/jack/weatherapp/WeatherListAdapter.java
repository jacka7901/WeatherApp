package com.jack.weatherapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jack.weatherapp.models.WeatherCondition;
import com.jack.weatherapp.models.WeatherData;

import java.util.List;

/**
 * Created by jack on 4/29/2016.
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder>{

    private List<WeatherData> weatherDataList;

    public TextView locationTextView;
    public TextView tempTextView;
    public TextView humidTextView;
    private OnWeatherListClickListener listener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Here we are inflating the CardView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_weather_card, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WeatherData weatherData = this.weatherDataList.get(position);
        CardView cardView = holder.cardView;
       cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.v("test", weatherData.getName());
               WeatherListAdapter.this.listener.onClick(weatherData);

           }
       });

        // We then add these items to each CardView
        locationTextView = (TextView) cardView.findViewById(R.id.locationTextView);
        tempTextView = (TextView) cardView.findViewById(R.id.tempTextView);
        humidTextView= (TextView) cardView.findViewById(R.id.humidText);

        locationTextView.setText(weatherData.getName());
        tempTextView.setText("Temperature: "+weatherData.getWeatherDetails().getTemperature());
        humidTextView.setText("Humidity: "+ weatherData.getWeatherDetails().getHumidity());

    }

    @Override
    public int getItemCount() {
        return this.weatherDataList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;



        public ViewHolder(View v){
            super(v);
            // Each ViewHolder only has a CardView (even though that CardView has child TextViews
            cardView = (CardView) v;
        }

    }


    public WeatherListAdapter(List<WeatherData> weatherDataList, OnWeatherListClickListener onWeatherListClickListener){
        this.weatherDataList = weatherDataList;
        this.listener = onWeatherListClickListener;
    }
}