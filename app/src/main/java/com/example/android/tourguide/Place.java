package com.example.android.tourguide;

/**
 * Created by Rachit on 10/28/2016.
 */
class Place {
    private String mText;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static int NO_IMAGE_PROVIDED = -1;
    private String mLocation;

    Place(String text, int imageResourceId, String location) {
        mLocation= location;
        mText = text;
        mImageResourceId = imageResourceId;
    }
    Place(String text, int imageResourceId) {
        mText = text;
        mImageResourceId = imageResourceId;
    }

    Place(String text, String location) {
        mLocation=location;
        mText = text;
    }

    String getLocation(){
        return mLocation;
    }

    int getImageResourceId() {
        return mImageResourceId;
    }

    String getText() {
        return mText;
    }

    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
