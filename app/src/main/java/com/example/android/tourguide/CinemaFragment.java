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
public class CinemaFragment extends Fragment {

    public CinemaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(getString(R.string.elante), R.drawable.elante, "30.705351, 76.801093"));
        places.add(new Place(getString(R.string.piccadily), R.drawable.piccadily, "30.723547, 76.767475"));
        places.add(new Place(getString(R.string.cinepolis), R.drawable.cinepolis, "30.742974, 76.785245"));
        places.add(new Place(getString(R.string.wave), R.drawable.wavecinema, "30.709581, 76.800988"));

        CustomListAdapter adapter = new CustomListAdapter(getContext(), places, R.color.cinemas);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Place pos = places.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + pos.getLocation() + "?q=" + pos.getText()));
                startActivity(intent);
            }
        });
    }

}
