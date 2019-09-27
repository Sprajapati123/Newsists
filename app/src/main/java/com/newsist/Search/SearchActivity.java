package com.newsist.Search;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.newsist.Home.CameraFragment;
import com.newsist.Home.HomeFragment;
import com.newsist.Home.MessageFragment;
import com.newsist.R;
import com.newsist.Utils.BottomNavigationViewHelper;
import com.newsist.Utils.SectionPagerAdapter;


public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";
    private static final int ACTIVITY_NUM = 1;

    private Context mContext = SearchActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Log.d(TAG, "onCreate: started.");

        setupBottomNavigationView();
//        setupBottomNavigationView();
//        setupViewPager();
    }

//    private void setupViewPager(){
//        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new CameraFragment()); //index 0
//        adapter.addFragment(new HomeFragment()); //index 1
//        adapter.addFragment(new MessageFragment()); //index 2
//        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
//        viewPager.setAdapter(adapter);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_logo);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
//    }

    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enabledNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
