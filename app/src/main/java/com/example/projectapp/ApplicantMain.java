package com.example.projectapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ApplicantMain extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ApplicantHomeFragment ApplicantHomeFragment = new ApplicantHomeFragment();
    ApplicantSearchFragment ApplicantSearchFragment = new ApplicantSearchFragment();
    ApplicantResumeFragment ApplicantResumeFragment = new ApplicantResumeFragment();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicantmain);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, ApplicantHomeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, ApplicantHomeFragment).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, ApplicantSearchFragment).commit();
                        return true;
                    case R.id.resume:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, ApplicantResumeFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}
