package com.mbkm.tugas9_gits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigation;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        mBottomNavigation.setOnNavigationItemSelectedListener(BottomMethod);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener BottomMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    fragment = null;
                    switch (item.getItemId()){
                        case R.id.home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.add:
                            fragment = new AddFragment();
                            break;

                        case R.id.about:
                            fragment = new AboutFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                    return true;
                }
            };
}