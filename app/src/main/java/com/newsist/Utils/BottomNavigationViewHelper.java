package com.newsist.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.newsist.Home.HomeActivity;
import com.newsist.Notification.NotificationActivity;
import com.newsist.Profile.ProfileActivity;
import com.newsist.R;
import com.newsist.Search.SearchActivity;
import com.newsist.Share.AddActivity;


public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enabledNavigation(final Context context, final Activity callingActivity, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent intent1 = new Intent(context, HomeActivity.class);//ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;

                    case R.id.ic_search:
                        Intent intent2  = new Intent(context, SearchActivity.class);//ACTIVITY_NUM = 1
                        context.startActivity(intent2);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;

                    case R.id.ic_add:
                        Intent intent3 = new Intent(context, AddActivity.class);//ACTIVITY_NUM = 2
                        context.startActivity(intent3);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;

                    case R.id.ic_notification:
                        Intent intent4 = new Intent(context, NotificationActivity.class);//ACTIVITY_NUM = 3
                        context.startActivity(intent4);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;

                    case R.id.ic_profile:
                        Intent intent5 = new Intent(context, ProfileActivity.class);//ACTIVITY_NUM = 4
                        context.startActivity(intent5);
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }


                return false;
            }
        });
    }
}