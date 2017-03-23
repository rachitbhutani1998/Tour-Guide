package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/29/2016.
 */
public class touristSpots extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words(getString(R.string.lake),"30.743938, 76.810869"));
        words.add(new Words(getString(R.string.rock),"30.753495, 76.805457"));
        words.add(new Words(getString(R.string.elante),"30.705563, 76.801254"));
        words.add(new Words(getString(R.string.rose),"30.749075, 76.800973"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.tourists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words pos = words.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+pos.getLocation()+"?q="+pos.getText()));
                startActivity(intent);
            }
        });
    }
}
