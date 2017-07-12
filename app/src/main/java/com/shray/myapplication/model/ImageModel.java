package com.shray.myapplication.model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shray on 10-07-2017.
 */

public class ImageModel {
    private String date;
    Drawable images;
    Boolean flag=false;

    public ImageModel(String date, Drawable images) {
        this.date = date;
        this.images = images;
    }

    public ImageModel(String date, Drawable images, Boolean flag) {
        this.date = date;
        this.images = images;
        this.flag = flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Drawable getImages() {
        return images;
    }

    public void setImages(Drawable images) {
        this.images = images;
    }
}
