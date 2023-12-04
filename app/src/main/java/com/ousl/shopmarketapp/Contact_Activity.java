package com.ousl.shopmarketapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Contact_Activity extends AppCompatActivity {

    private TextView call, feedbackEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action Bar
        setContentView(R.layout.contact_activity);

        // For Call to Number
        call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+9478123325"; // Replace with your desired phone number
                dialPhoneNumber(phoneNumber);
            }
        });

        // For Send Email
        feedbackEmail = findViewById(R.id.feedback_email);
        feedbackEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = "dpmailzone@Gmail.com"; // Replace with your desired email address
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
}
