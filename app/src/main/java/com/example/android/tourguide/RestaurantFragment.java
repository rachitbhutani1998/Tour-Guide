package com.example.android.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<Place> words = new ArrayList<Place>();

        words.add(new Place(getString(R.string.subway), R.drawable.subway));
        words.add(new Place(getString(R.string.mcdonalds), R.drawable.mcdonalds));
        words.add(new Place(getString(R.string.dominos), R.drawable.dominos));
        words.add(new Place(getString(R.string.bbq), R.drawable.bbqnation));
        words.add(new Place(getString(R.string.kfc), R.drawable.kfc));

        CustomListAdapter adapter = new CustomListAdapter(getContext(), words, R.color.restaurants);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place pos = words.get(position);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + "?q=" + pos.getText() + " in Chandigarh"));
                startActivity(mapIntent);
            }
        });
    }
}
