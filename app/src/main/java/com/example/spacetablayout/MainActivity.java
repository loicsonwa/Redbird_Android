package com.example.spacetablayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.spacetablayout.main_fragments.Fragment_A;
import com.example.spacetablayout.main_fragments.Fragment_B;
import com.example.spacetablayout.main_fragments.Fragment_C;
import com.example.spacetablayout.main_fragments.Fragment_D;
import com.example.spacetablayout.main_fragments.Fragment_E;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        getWindow().setStatusBarColor(getColor(R.color.logo_color));
        setContentView(R.layout.activity_main);

        // Ajout d'une liste de fragments
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_A());
        fragmentList.add(new Fragment_B());
        fragmentList.add(new Fragment_C());
        fragmentList.add(new Fragment_D());
        fragmentList.add(new Fragment_E());

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        SpaceTabLayout spaceTabLayout = findViewById(R.id.spaceTabLayout);


        spaceTabLayout.initialize(viewPager,getSupportFragmentManager(), fragmentList,savedInstanceState);



        int imgMap = R.drawable.geo_fence_filled_24px;
        int imgProfile = R.drawable.contacts_filled_24px;
        int imgCatalog = R.drawable.magazine_filled_24px;
        int imgShop = R.drawable.buy_24px;
        int imgDelivry = R.drawable.delivery_24px;

        spaceTabLayout.setTabFiveIcon(imgProfile);
        spaceTabLayout.setTabFourIcon(imgMap);
        spaceTabLayout.setTabThreeIcon(imgCatalog);
        spaceTabLayout.setTabTwoIcon(imgShop);
        spaceTabLayout.setTabOneIcon(imgDelivry);

    }
}
