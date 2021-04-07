package com.example.myapp;



import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    NavigationView navigationDrawer;
    NavController navController;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,new HomeFragment()).commit();
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration().Builder(R.id);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch(menuItem.getItemId()){
                case R.id.home_bottom_nav:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.drink_bottom_nav:
                    selectedFragment = new DrinksFragment();
                    break;
                case R.id.order_bottom_nav:
                    selectedFragment = new OrderFragment();
                    break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,selectedFragment).commit();

            return true;
    }


    };



}