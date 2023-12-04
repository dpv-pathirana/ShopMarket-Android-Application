package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.ousl.shopmarketapp.Category_Activity;
import com.ousl.shopmarketapp.R;
import com.ousl.shopmarketapp.views.MainActivity;

public class Shops_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView category_TXT;
    private RelativeLayout RelativeLayout_Shop1;
    private Button about_shop_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action Bar
        setContentView(R.layout.shop_activity);

        category_TXT = (TextView) findViewById(R.id.categoryTXT);
        about_shop_BTN = (Button) findViewById(R.id. about_shopBTN1);
        RelativeLayout_Shop1 = (RelativeLayout) findViewById(R.id.RelativeLayout_Shop1);

        category_TXT.setOnClickListener(this);
        about_shop_BTN.setOnClickListener(this);
        RelativeLayout_Shop1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.RelativeLayout_Shop1:
                Intent intentRelativeLayout = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentRelativeLayout);
                break;

            case R.id.categoryTXT:
                Intent intentCategory = new Intent(getApplicationContext(), Category_Activity.class);
                startActivity(intentCategory);
                break;
            case R.id.about_shopBTN1:
                Intent intentAboutShop = new Intent(getApplicationContext(), ShopAbout_Activity.class);
                startActivity(intentAboutShop);
                break;


        }

    }
}