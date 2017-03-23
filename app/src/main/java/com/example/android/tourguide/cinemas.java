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
public class cinemas extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.elante), R.drawable.elante,"30.705351, 76.801093"));
        words.add(new Words(getString(R.string.cinepolis), R.drawable.cinepolis,"30.742974, 76.785245"));
        words.add(new Words(getString(R.string.piccadily), R.drawable.piccadily,"30.723547, 76.767475"));
        words.add(new Words(getString(R.string.wave), R.drawable.wavecinema,"30.709581, 76.800988"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.cinemas);
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
