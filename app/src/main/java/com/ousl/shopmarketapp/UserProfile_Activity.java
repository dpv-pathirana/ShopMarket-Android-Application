package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView EditProfileButtonTXT, logOutButtonTXT, setting_TXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action bar
        setContentView(R.layout.user_profile_activity);

        EditProfileButtonTXT = (TextView) findViewById(R.id.EditProfileTXT);
        setting_TXT = (TextView) findViewById(R.id.settingTXT);
        logOutButtonTXT = (TextView) findViewById(R.id.logOutTXT);

        EditProfileButtonTXT.setOnClickListener(this);
        setting_TXT.setOnClickListener(this);
        logOutButtonTXT.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.EditProfileTXT:
                Intent intentEditProfile = new Intent(getApplicationContext(), EditProfile_Activity.class);
                startActivity(intentEditProfile);
                break;
            case R.id.logOutTXT:
                Toast.makeText(this, "Log Out Successfully", Toast.LENGTH_SHORT).show();
                Intent intentLogOut = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intentLogOut);
                break;

            case R.id.settingTXT:
                Intent intentSettings = new Intent(getApplicationContext(), Setting_Activity.class);
                startActivity(intentSettings);
                break;
        }
    }
}
