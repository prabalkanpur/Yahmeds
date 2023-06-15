package com.yahmeds.healthcare.activities

import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yahmeds.healthcare.R


class BookAmbulanceActivity : FragmentActivity(), OnMapReadyCallback {

    private lateinit var currentLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var mButtonCurrentLocation: ImageView;
    private val permissionCode = 101
    lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_ambulance)
        val mapFragment =
            supportFragmentManager.findFragmentById(com.yahmeds.healthcare.R.id.myMap) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
        mButtonCurrentLocation = findViewById(R.id.button_current_loction)
        mButtonCurrentLocation.setOnClickListener {
            // TODO Auto-generated method stub
            getLastLocation()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val myPos = LatLng(28.5730, 77.3249)
        // val latLng = LatLng(currentLocation.latitude, currentLocation.longitude)
        val markerOptions = MarkerOptions().position(myPos).title("I am here!")
        googleMap?.animateCamera(CameraUpdateFactory.newLatLng(myPos))
        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(myPos, 16f))
        googleMap?.addMarker(markerOptions)
        Log.i("map_load", "map")
    }

    // Get current location
    private fun getLastLocation() {
        val myPos = LatLng(28.5730, 77.3249)
        if (myPos != null) {
            mMap.clear()
            mMap.addMarker(MarkerOptions().position(myPos))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPos, 16F))
        }

    }
}
