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
public class hotels extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.jw),"30.726695, 76.767146"));
        words.add(new Words(getString(R.string.taj),"30.745562, 76.785173"));
        words.add(new Words(getString(R.string.shivalik),"30.740094, 76.776769"));
        words.add(new Words(getString(R.string.lemon),"30.706146, 76.802956"));
        words.add(new Words(getString(R.string.lalit),"30.730650, 76.841410"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.hotels);
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
