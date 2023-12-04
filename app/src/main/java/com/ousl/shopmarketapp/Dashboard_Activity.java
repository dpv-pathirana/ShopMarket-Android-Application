package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ousl.shopmarketapp.models.CartItem;
import com.ousl.shopmarketapp.views.CartFragment;

public class Dashboard_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView contactUsIcon, settingsIcon, aboutUsIcon, categoryIcon, profileIcon, cartIcon;
    private TextView getShopTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action bar
        setContentView(R.layout.dashboard_activity);

        // Get id and assign to variables
        categoryIcon = (ImageView) findViewById(R.id.categorys_icon);
        cartIcon = (ImageView) findViewById(R.id.cart_icon);
        settingsIcon = (ImageView) findViewById(R.id.settings_icon);
        profileIcon = (ImageView) findViewById(R.id.profile_icon);
        aboutUsIcon = (ImageView) findViewById(R.id.about_us);
        contactUsIcon = (ImageView) findViewById(R.id.contact_us_icon);
        getShopTXT = (TextView) findViewById(R.id.getShops);


        // setOnClickListener
        categoryIcon.setOnClickListener(this);
        cartIcon.setOnClickListener(this);
        settingsIcon.setOnClickListener(this);
        profileIcon.setOnClickListener(this);
        aboutUsIcon.setOnClickListener(this);
        contactUsIcon.setOnClickListener(this);
        getShopTXT.setOnClickListener(this);

    }

    // setOnClickListener Method
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // On Click Category_Activity
            case R.id.categorys_icon:
                Intent intentCategory = new Intent(getApplicationContext(), Category_Activity.class);
                startActivity(intentCategory);
                break;

            // On Click Setting_Activity
            case R.id.settings_icon:
                Intent intentNotification = new Intent(getApplicationContext(), Setting_Activity.class);
                startActivity(intentNotification);
                break;

            // On Click Category_Activity
            case R.id.profile_icon:
                Intent intentProfile = new Intent(getApplicationContext(), UserProfile_Activity.class);
                startActivity(intentProfile);
                break;

            // On Click UserProfile_Activity
            case R.id.about_us:
                Intent intentAboutUs = new Intent(getApplicationContext(), AboutUs_Activity.class);
                startActivity(intentAboutUs);
                break;

            // On Click Contact_Activity
            case R.id.contact_us_icon:
                Intent intentContactUs = new Intent(getApplicationContext(), Contact_Activity.class);
                startActivity(intentContactUs);
                break;

            // On Click Shops_Activity
            case R.id.getShops:
                Intent intentGetShops = new Intent(getApplicationContext(), Shops_Activity.class);
                startActivity(intentGetShops);
                break;

        }

    }
}
