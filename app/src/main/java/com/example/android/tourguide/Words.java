package com.example.android.tourguide;

import android.net.Uri;

/**
 * Created by Rachit on 10/28/2016.
 */
public class Words {
    private String mText;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static int NO_IMAGE_PROVIDED = -1;
    private String mLocation;

    public Words(String text, int imageResourceId,String location) {
        mLocation= location;
        mText = text;
        mImageResourceId = imageResourceId;
    }
    public Words(String text, int imageResourceId) {
        mText = text;
        mImageResourceId = imageResourceId;
    }

    public Words(String text,String location) {
        mLocation=location;
        mText = text;
    }

    public String getLocation(){
        return mLocation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getText() {
        return mText;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
