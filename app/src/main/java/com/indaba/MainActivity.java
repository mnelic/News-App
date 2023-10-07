package com.indaba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,msport,mscience,mhealth,mentertainment,mtecthnology;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    String  api = "32b98e3acce0ee23532922ec67062718";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar =  findViewById(R.id.toolbbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.home);
        msport = findViewById(R.id.Sport);
        mhealth = findViewById(R.id.Health);
        mscience = findViewById(R.id.Science);
        mentertainment = findViewById(R.id.Entertainment);
        mtecthnology = findViewById(R.id.Technology);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);

        viewPager.setAdapter(pagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                      viewPager.setCurrentItem(tab.getPosition());

                      if(tab.getPosition() == 0 ||tab.getPosition() == 1 || tab.getPosition() == 2 ||tab.getPosition() == 3 ||tab.getPosition() == 4 ||tab.getPosition() == 5)
                      {
                          pagerAdapter.notifyDataSetChanged();
                      }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}