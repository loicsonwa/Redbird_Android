package com.example.spacetablayout.sliders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.spacetablayout.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Slider extends AppCompatActivity {
    List<Integer> listImage;
    List<String> listDescription;
    ViewPager viewPager;
    TabLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        listImage = new ArrayList<>();
        listImage.add(R.drawable.presentation);
        listImage.add(R.drawable.presentation);
        listImage.add(R.drawable.presentation);

        listDescription = new ArrayList<>();
        listDescription.add("Slide 01");
        listDescription.add("Slide 02");
        listDescription.add("Slide 03");


        viewPager = findViewById(R.id.slide_viewPager);
        indicator = findViewById(R.id.indicator);

        SlideAdapter slideAdapter = new SlideAdapter(this,listImage,listDescription);
        viewPager.setAdapter(slideAdapter);

        indicator.setupWithViewPager(viewPager, true);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000, 6000);

        // Timer pour l"auto-sliding


    }
    private class SliderTimer extends TimerTask{

        @Override
        public void run() {
            Slider.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() < listImage.size() -1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem() +1);
                    } else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
