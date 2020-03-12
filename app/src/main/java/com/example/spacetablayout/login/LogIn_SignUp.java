package com.example.spacetablayout.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.spacetablayout.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import co.ceryle.segmentedbutton.SegmentedButtonGroup;

public class LogIn_SignUp extends AppCompatActivity {
    private static final int NUM_PAGES = 2;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in__sign_up);
        viewPager = findViewById(R.id.login_viewPager);

        pagerAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);



        SegmentedButtonGroup segmentedButtonGroup = findViewById(R.id.segmentBtn);
        segmentedButtonGroup.setPosition(0);
        segmentedButtonGroup.setOnClickedButtonListener(new SegmentedButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(int position) {
                if(position == 0){
                    viewPager.setCurrentItem(0, true);

                    Toast.makeText(LogIn_SignUp.this, "Login", Toast.LENGTH_SHORT).show();
                }
                else if(position == 1){
                    viewPager.setCurrentItem(1, true);
                    Toast.makeText(LogIn_SignUp.this,"Sign Up", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public static class MyAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> fragments = new ArrayList<>();

        MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new LogFragment();
                case 1: return new SignFragment();
            }
            return new LogFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }


    }



}
