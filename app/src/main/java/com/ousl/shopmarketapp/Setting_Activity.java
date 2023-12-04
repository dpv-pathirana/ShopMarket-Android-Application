package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Setting_Activity extends AppCompatActivity implements View.OnClickListener{

    private Button settingsEditProfileBTN;
    private RelativeLayout layout_Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action bar
        setContentView(R.layout.setting_activity);

        settingsEditProfileBTN = (Button) findViewById(R.id.settings_edit_profile_BTN);
        layout_Logout = (RelativeLayout) findViewById(R.id.layoutLogout);


        settingsEditProfileBTN.setOnClickListener(this);
        layout_Logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settings_edit_profile_BTN:
                Intent intentEditProfile = new Intent(getApplicationContext(), EditProfile_Activity.class);
                startActivity(intentEditProfile);
                break;

            case R.id.layoutLogout:
                Toast.makeText(this, "Log Out Successfully", Toast.LENGTH_SHORT).show();
                Intent intentLogout = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intentLogout);
                break;
        }
    }
}