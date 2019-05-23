package com.example.android.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class CategoryActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private MenuItem currentMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final DrawerLayout mDrawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment newFragment = null;
                if (currentMenuItem != null)
                    currentMenuItem.setChecked(false);
                switch (menuItem.getItemId()) {
                    case R.id.cinema_item:
                        newFragment = new CinemaFragment();
                        break;
                    case R.id.clubs_item:
                        newFragment = new ClubsFragment();
                        break;
                    case R.id.hotels_item:
                        newFragment = new HotelsFragment();
                        break;
                    case R.id.restaurant_item:
                        newFragment = new RestaurantFragment();
                        break;
                    case R.id.spots_item:
                        newFragment = new SpotsFragment();
                        break;
                }

                if (newFragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.frag_container, newFragment)
                            .commit();
                    menuItem.setChecked(true);
                    currentMenuItem = menuItem;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
