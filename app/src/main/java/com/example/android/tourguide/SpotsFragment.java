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
public class SpotsFragment extends Fragment {


    public SpotsFragment() {
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

        words.add(new Place(getString(R.string.lake), "30.743938, 76.810869"));
        words.add(new Place(getString(R.string.rock), "30.753495, 76.805457"));
        words.add(new Place(getString(R.string.elante), "30.705563, 76.801254"));
        words.add(new Place(getString(R.string.rose), "30.749075, 76.800973"));
        CustomListAdapter adapter = new CustomListAdapter(getContext(), words, R.color.tourists);
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
