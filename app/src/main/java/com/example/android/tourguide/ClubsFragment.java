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
public class ClubsFragment extends Fragment {


    public ClubsFragment() {
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
        final ArrayList<Place> words = new ArrayList<Place>();
        words.add(new Place(getString(R.string.haze), R.drawable.haze, "30.738426, 76.785372"));
        words.add(new Place(getString(R.string.paara), R.drawable.paara, "30.706960, 76.796567"));
        words.add(new Place(getString(R.string.score), R.drawable.score, "30.735747, 76.796196"));
        CustomListAdapter adapter = new CustomListAdapter(getContext(), words, R.color.clubs);
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
