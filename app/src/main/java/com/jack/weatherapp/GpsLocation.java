package com.jack.steamcalculator;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by jack on 4/27/2016.
 */
public class GpsLocation implements LocationListener {

   // LocationManager locationManager=    (LocationManager)getSystemService(Context.LOCATION_SERVICE);
   // MyCurrentLoctionListener locationListener = new MyCurrentLoctionListener();
   // locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,locationListener);


//String locationProvider = LocationManager.GPS_PROVIDER;

    // locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);

    public void onLocationChanged(Location location) {
        location.getLatitude();
        location.getLongitude();

        String myLocation = "Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude();
        double myLat = location.getLatitude();
        double myLong = location.getLongitude();

        //I make a log to see the results
        Log.e("MY CURRENT LOCATION", myLocation);

    }

    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    public void onProviderEnabled(String s) {

    }

    public void onProviderDisabled(String s) {

    }




}
