package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopAbout_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView GalleryButtonIcon;
    private TextView email_TXT, phoneNumber_TXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action Bar
        setContentView(R.layout.shop_about_activity);

        // Replace Created Map Fragment page on ShopAbout Activity layout
        Fragment fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout1,fragment).commit();

        // OnClickListener implementation of shop Gallery Button
        GalleryButtonIcon = (ImageView) findViewById(R.id.galleryIcon);
        GalleryButtonIcon.setOnClickListener(this);

        // For Call to Number
        phoneNumber_TXT = findViewById(R.id.phoneNumber_TXT);
        phoneNumber_TXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+9476325487"; // Replace with your desired phone number
                dialPhoneNumber(phoneNumber);
            }
        });

        // For Send Email
        email_TXT = findViewById(R.id.email_TXT);
        email_TXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = "john.davis@chama.com"; // Replace with your desired email address
                sendEmail(emailAddress);
            }
        });

    }

    // Dial Number
    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Send Email
    private void sendEmail(String emailAddress) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + emailAddress));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Open Google Map For Touch Location
    public void openMapsApp(View view) {
        TextView address_TXT = (TextView) view;
        String address = address_TXT.getText().toString();

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    // Navigation
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.galleryIcon:
                Intent intentShopGallery = new Intent(getApplicationContext(), ShopGallery_Activity.class);
                startActivity(intentShopGallery);
                break;
        }
    }
}
