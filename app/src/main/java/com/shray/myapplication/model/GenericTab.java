package com.shray.myapplication.model;

import android.app.Fragment;

/**
 * Created by user12 on 14/7/17.
 */

public class GenericTab {
    private Fragment fragments;
    private String title;
    private int drawable;
    private boolean showTitle;

    public GenericTab(Fragment fragments, String title, int drawable) {
        this.fragments = fragments;
        this.title = title;
        this.drawable = drawable;
    }

    public Fragment getFragments() {
        return fragments;
    }

    public void setFragments(Fragment fragments) {
        this.fragments = fragments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public boolean isShowTitle() {
        return showTitle;
    }

    public void setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
    }
}
