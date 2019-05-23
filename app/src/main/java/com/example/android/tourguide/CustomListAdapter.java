package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/28/2016.
 */
public class CustomListAdapter extends ArrayAdapter<Place> {
    private int mBackgroundColor;

    CustomListAdapter(Context context, ArrayList<Place> word, int backgroundColor) {
        super(context, 0, word);
        mBackgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView textView = listItemView.findViewById(R.id.name);
        ImageView iconView = listItemView.findViewById(R.id.icon);

        if (currentPlace != null) {
            textView.setText(currentPlace.getText());
            if (currentPlace.hasImage()) {
                iconView.setImageResource(currentPlace.getImageResourceId());
            } else {
                iconView.setVisibility(View.GONE);
            }
        }


        View textContainer = listItemView.findViewById(R.id.item_container);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
