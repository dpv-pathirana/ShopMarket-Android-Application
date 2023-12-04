package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Category_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action bar
        setContentView(R.layout.category_activity);
    }
}