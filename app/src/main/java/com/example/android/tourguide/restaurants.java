package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words(getString(R.string.subway), R.drawable.subway));
        words.add(new Words(getString(R.string.mcdonalds), R.drawable.mcdonalds));
        words.add(new Words(getString(R.string.dominos), R.drawable.dominos));
        words.add(new Words(getString(R.string.bbq), R.drawable.bbqnation));
        words.add(new Words(getString(R.string.kfc), R.drawable.kfc));

        InputAdapter adapter = new InputAdapter(this, words, R.color.restaurants);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words pos = words.get(position);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + "?q=" + pos.getText() + " in Chandigarh"));
                startActivity(mapIntent);
            }
        });
    }
}
