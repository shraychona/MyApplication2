package com.shray.myapplication.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;
import com.shray.myapplication.model.Ads;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SellYourStuff extends BaseActivity {

    private String[] catagory = {"English", "Maths","Java","Android","Python","JS"};
    private ListPopupWindow listPopupWindow;
    private static final int NUM_PAGES = 12;
    @BindView(R.id.VPAds) ViewPager VPAds;
    @BindView(R.id.TVContent) TextView tv;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_your_stuff);
        ButterKnife.bind(this);

        //setSupportActionBar(toolbar);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        VPAds.setAdapter(mPagerAdapter);
        listPopupWindow =new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<>(SellYourStuff.this,R.layout.support_simple_spinner_dropdown_item,catagory));
        listPopupWindow.setAnchorView(tv);
        listPopupWindow.setModal(true);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPopupWindow.show();
            }
        });

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(catagory[position]);
                listPopupWindow.dismiss();
            }
        });

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new Ads();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public float getPageWidth(int position) {
            return(0.3f);
        }
    }
}
