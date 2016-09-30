package com.jack.weatherapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jack.weatherapp.models.ForecastWeatherData;
import com.jack.weatherapp.models.WeatherCondition;
import com.jack.weatherapp.models.WeatherData;

public class MainActivity extends AppCompatActivity {

    private LocationManager manager;
    private LocationListener listener;
    TextView locationText;
    TextView tempText;
    TextView highText;
    TextView lowText;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherListActivity.class);
                startActivity(intent);
            }
        });

        final WeatherApiManager weatherApiManager = new WeatherApiManager();
        weatherApiManager.getWeatherByCoordinate(35.744644099999995, -78.86395929999999, new WeatherCallback() {
            @Override
            public void weatherDownloadCompleted(boolean success, WeatherData weatherData) {



                Log.v("weather","temperature: "+ weatherData.getWeatherDetails().getTemperature());
                locationText = (TextView) findViewById(R.id.textView);
                tempText = (TextView) findViewById(R.id.textView2);

               // highText = (TextView) findViewById(R.id.hightext);
               // lowText = (TextView) findViewById(R.id.lowtext);

                locationText.setText(""+weatherData.getName() );
                tempText.setText(""+ weatherData.getWeatherDetails().getTemperature());
                //highText.setText(""+weatherData.getWeatherDetails().getMaxTemperature());
               // lowText.setText(""+weatherData.getWeatherDetails().getMinTemperature());












            }
        });

//       final TextView gpsText = (TextView) findViewById(R.id.textView);
//        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        listener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                location.getLatitude();
//                location.getLongitude();
//
//                String myLocation = "Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude();
//                double myLat = location.getLatitude();
//                double myLong = location.getLongitude();
//
//                //I make a log to see the results
//                Log.e("MY CURRENT LOCATION", myLocation);
//
//                gpsText.setText(myLocation);
//
//
//
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        };
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//
//
//        manager.requestLocationUpdates("gps", 5000, 0, listener);








    }
}
