package com.ousl.shopmarketapp;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;
import android.widget.MediaController;

import androidx.appcompat.app.AppCompatActivity;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;

public class ShopGallery_Activity extends AppCompatActivity {

    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide Action Bar
        setContentView(R.layout.shopgallery_activity);

        // Video View Implementation of Shop Gallery Page
        VideoView videoView = findViewById(R.id.videoView1);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.chamacomputersshop);
        videoView.start();

        // Media Controller Implementation
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Slide Show Images Implementation of Shop Gallery Page
        imageSlider = findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        // Images Implementation
        slideModels.add(new SlideModel(R.drawable.slideshow_chamaimg1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slideshow_chamaimg2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slideshow_chamaimg3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slideshow_chamaimg4, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


    }
}
