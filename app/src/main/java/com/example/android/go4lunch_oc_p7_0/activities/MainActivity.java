package com.example.android.go4lunch_oc_p7_0.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.android.go4lunch_oc_p7_0.R;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // FOR DESIGN
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Change the color of the status bar to orange
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_700));

        // Configure all views
        this.configureToolBar();
        this.configureDrawerLayout();
        this.configureNavigationView();
    }

    // Handle the back button to close the navigation drawer
    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Handle the selection of a navigation item
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_lunch:
                // Handle the "Lunch" menu item
                break;
            case R.id.nav_settings:
                // Handle the "Settings" menu item
                break;
            case R.id.nav_logout:
                // Handle the "Logout" menu item
                break;
            default:
                break;
        }

        // Close the navigation drawer
        this.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    // Configuration methods for the toolbar, drawer layout, and navigation view
    private void configureToolBar() {
        // Get a reference to the toolbar and set it as the action bar
        this.toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);

        // Change the color of the toolbar title and menu icon to white
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color='#ffffff'>I'm Hungry</font>"));

        // Change the color of the toolbar text
        toolbar.setTitleTextColor(Color.WHITE);
    }

    private void configureDrawerLayout() {
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerArrowDrawable(new DrawerArrowDrawable(this));
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigationView() {
        // Get a reference to the navigation view and set up the listener for item selection
        NavigationView navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
