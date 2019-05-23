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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<Place> words = new ArrayList<Place>();
        words.add(new Place(getString(R.string.jw), "30.726695, 76.767146"));
        words.add(new Place(getString(R.string.taj), "30.745562, 76.785173"));
        words.add(new Place(getString(R.string.shivalik), "30.740094, 76.776769"));
        words.add(new Place(getString(R.string.lemon), "30.706146, 76.802956"));
        words.add(new Place(getString(R.string.lalit), "30.730650, 76.841410"));
        CustomListAdapter adapter = new CustomListAdapter(getContext(), words, R.color.hotels);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place pos = words.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + pos.getLocation() + "?q=" + pos.getText()));
                startActivity(intent);
            }
        });
    }
}
