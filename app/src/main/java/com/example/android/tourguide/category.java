package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        TextView restaurantTextView = (TextView) findViewById(R.id.restaurants);
        TextView cinemasTextView = (TextView) findViewById(R.id.cinemas);
        TextView hotelsTextView = (TextView) findViewById(R.id.hotels);
        final TextView touristsTextView = (TextView) findViewById(R.id.tourists);
        TextView clubsTextView = (TextView) findViewById(R.id.clubs);
        restaurantTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantI = new Intent(category.this, restaurants.class);
                startActivity(restaurantI);
            }
        });
        hotelsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelsI = new Intent(category.this, hotels.class);
                startActivity(hotelsI);
            }
        });
        cinemasTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cinemasI = new Intent(category.this, cinemas.class);
                startActivity(cinemasI);
            }
        });
        touristsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent touristsI = new Intent(category.this, touristSpots.class);
                startActivity(touristsI);
            }
        });
        clubsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubsI = new Intent(category.this, clubs.class);
                startActivity(clubsI);
            }
        });

    }
}
