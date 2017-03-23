package com.example.android.tourguide;

import android.app.Activity;
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
public class InputAdapter extends ArrayAdapter<Words> {
    private int mBackgroundColor;

    public InputAdapter(Activity context, ArrayList<Words> word, int backgroundColor) {
        super(context, 0, word);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Words currentWords = getItem(position);

        TextView textView = (TextView) listItemView.findViewById(R.id.name);
        textView.setText(currentWords.getText());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon);
        if (currentWords.hasImage()) {
            iconView.setImageResource(currentWords.getImageResourceId());
        } else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.name);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
