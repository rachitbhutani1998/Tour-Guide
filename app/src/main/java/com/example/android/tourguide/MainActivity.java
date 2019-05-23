package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        LinearLayout frontPage = findViewById(R.id.welcome);
        if (frontPage != null) {
            frontPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent categoryI = new Intent(MainActivity.this, CategoryActivity.class);
                    startActivity(categoryI);
                    finish();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categories, menu);
        return true;
    }
}
