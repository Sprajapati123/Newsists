package com.newsist.Utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.newsist.AddActivity;
import com.newsist.HomeActivity;
import com.newsist.NotificationActivity;
import com.newsist.ProfileActivity;
import com.newsist.R;
import com.newsist.SearchActivity;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupButtonNavigationView: Setting up ButtonNavigationView ");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enabledNavigation (final Context context, BottomNavigationViewEx viewEx){
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()){
                   case R.id.ic_home:
                       context.startActivity(new Intent(context, HomeActivity.class));
                       break;

                   case R.id.ic_add:
                    context.startActivity(new Intent(context, AddActivity.class));
                       break;

                   case R.id.ic_search:
                       context.startActivity(new Intent(context, SearchActivity.class));
                       break;

                   case R.id.ic_notification:
                       context.startActivity(new Intent(context, NotificationActivity.class));
                       break;

                   case R.id.ic_profile:
                       context.startActivity(new Intent(context, ProfileActivity.class));
                           break;
               }

                return false;
            }
        });
    }
}
