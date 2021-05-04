package com.example.myapp.UI.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapp.R;
import com.example.myapp.UI.ViewModels.DrinkViewModel;
import com.example.myapp.UI.ViewModels.MainActivityViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener  {

    NavController navController;
    AppBarConfiguration appBarConfiguration;
    DrawerLayout drawer;
    BottomNavigationView bottomNavigationView;
    NavigationView navigation_view;
    Toolbar toolbar;
    MainActivityViewModel viewModel;
    DrinkViewModel viewModelDrink;
    TextView placeholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.init();


        checkIfSignedIn();
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        navigation_view = findViewById(R.id.navigation_view);

        toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.navigation_drawer);

        setupNavigation();

        setNavigationViewListener();

        //setCurrentUserText();


    }

    private void setupNavigation() {
        navController = Navigation.findNavController(this,R.id.fragment_container);
        setSupportActionBar(toolbar);

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home,
                R.id.drink,
                R.id.order
        ).setOpenableLayout(drawer).build();

        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
        NavigationUI.setupWithNavController(navigation_view,navController);

        setBottomNavigationVisibility();
    }

    private void setBottomNavigationVisibility() {
        navController.addOnDestinationChangedListener((new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch ((destination.getId())){
                    default:
                        bottomNavigationView.setVisibility(View.GONE);
                        break;
                    case R.id.home:
                    case R.id.drink:
                    case R.id.order:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                }
            }
        }));
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration)|| super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen((GravityCompat.START)))
            drawer.closeDrawer(GravityCompat.START);

        else
            super.onBackPressed();
    }

    //firebase
    private void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                Context context = getApplicationContext();
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, text, duration).show();
            } else
                startLoginActivity();
        });


    }



    public void getCurrentUser(){
        viewModel.getCurrentUser();
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void signOut() {
        viewModel.signOut();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //navigation Drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.sign_out: {
                signOut();
                break;
            }

        }drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setCurrentUserText(){
        placeholder=findViewById(R.id.current_user);
        placeholder.setText("rasmus");
    }
}