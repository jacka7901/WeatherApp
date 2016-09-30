package com.jack.weatherapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jack.weatherapp.models.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class WeatherListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<WeatherData> mWeatherDataList;
    WeatherListAdapter mAdpapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWeatherDataList = new ArrayList<WeatherData>();
        mAdpapter = new WeatherListAdapter(mWeatherDataList, new OnWeatherListClickListener() {
            @Override
            public void onClick(WeatherData weatherData) {

            }
        });
        recyclerView.setAdapter(mAdpapter);







//        final WeatherApiManager weatherApiManager = new WeatherApiManager();
//        weatherApiManager.getWeatherByCoordinate(35.744644099999995, -78.86395929999999, new WeatherCallback() {
//            @Override
//            public void weatherDownloadCompleted(boolean success, WeatherData weatherData) {
//                List<WeatherData> weatherDataList = new ArrayList<WeatherData>();
//                List<WeatherData> mList = new ArrayList<WeatherData>();
//               weatherDataList.add(weatherData);
//               weatherDataList.add(weatherData);
//
//                mAdpapter = new WeatherListAdapter(weatherDataList);
//
//
//
//
//
//
//                //why does this have to be in here?
//                recyclerView.setAdapter(mAdpapter);
//
//
//
//            }
//        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
if (fab != null){
    fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WeatherListActivity.this);
                builder.setTitle("Enter A Zip Code");

                final EditText input = new EditText(WeatherListActivity.this);
                input.setInputType(InputType.TYPE_CLASS_PHONE);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String zipText = input.getText().toString();
                        try {
                            int zip = Integer.parseInt(zipText);
                            final WeatherApiManager weatherApiManager = new WeatherApiManager();
                            weatherApiManager.getWeatherByZipcode(zip, new WeatherCallback() {
                                @Override
                                public void weatherDownloadCompleted(boolean success, WeatherData weatherData) {


                                    mWeatherDataList.add(weatherData);
                                    updateUI();


                                }
                            });

                        } catch (NumberFormatException e) {

                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();




            }
        });


    }}

   void updateUI() {
        // The list we passed to the mAdapter was changed so we have to notify it in order to update
mAdpapter.notifyDataSetChanged();
    }
}
