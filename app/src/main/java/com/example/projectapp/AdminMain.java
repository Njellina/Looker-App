package com.example.projectapp;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationBarView;

public class AdminMain extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    AdminHomeFragment AdminHomeFragment = new AdminHomeFragment();
    AdminSearchFragment AdminSearchFragment = new AdminSearchFragment();
    AdminViewFragment AdminViewFragment = new AdminViewFragment();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminmain);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        replaceFragment(new ApplicantHomeFragment());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, AdminHomeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, AdminHomeFragment).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, AdminSearchFragment).commit();
                        return true;
                    case R.id.view:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, AdminViewFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}
