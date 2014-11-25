package com.example.mylocator;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class map extends FragmentActivity {

	
	 private GoogleMap myMap;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.map);
		
		
		 FragmentManager myFragmentManager = getSupportFragmentManager();
         SupportMapFragment mySupportMapFragment = (SupportMapFragment) myFragmentManager
                 .findFragmentById(R.id.map);
         myMap = mySupportMapFragment.getMap();
         myMap.getUiSettings().setZoomControlsEnabled(true);
         myMap.getUiSettings().setCompassEnabled(true);
         myMap.getUiSettings().setRotateGesturesEnabled(true);
         myMap.getUiSettings().setMyLocationButtonEnabled(true);
	}
	
}
