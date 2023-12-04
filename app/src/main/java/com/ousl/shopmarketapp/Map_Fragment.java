package com.ousl.shopmarketapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_Fragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map_,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.MY_MAP);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                GoogleMap mMap = googleMap;

                // Add a marker in Chama Computer shop Location and move the camera
                LatLng chamaComputers = new LatLng(7.169484427695239, 79.95260463843915);
                mMap.addMarker(new MarkerOptions().position(chamaComputers).title("Chama Computers"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chamaComputers, 18.0f));
                mMap.getUiSettings().setZoomControlsEnabled(true);
            }
        });
        return view;
    }
}
