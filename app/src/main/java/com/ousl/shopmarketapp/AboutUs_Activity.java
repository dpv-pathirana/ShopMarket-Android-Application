package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutUs_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action Bar
        setContentView(R.layout.about_us_activity);

    }
}