package com.shray.myapplication.adapter;



import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.shray.myapplication.R;
import com.shray.myapplication.model.GenericTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user12 on 14/7/17.
 */

public class ViewPagerTabAdapter extends FragmentPagerAdapter {

    private List<GenericTab> tabList=new ArrayList<>();

    public ViewPagerTabAdapter(FragmentManager fm, List<GenericTab> tabList) {
        super(fm);
        this.tabList=tabList;
    }

    @Override
    public Fragment getItem(int position) {
        return tabList.get(position).getFragments();
    }

    @Override
    public int getCount() {
        return tabList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position).getTitle();
    }

}
