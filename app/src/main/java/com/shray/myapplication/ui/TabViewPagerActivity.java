package com.shray.myapplication.ui;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shray.myapplication.R;
import com.shray.myapplication.adapter.ViewPagerTabAdapter;
import com.shray.myapplication.fragment.FirstFragment;
import com.shray.myapplication.fragment.ScondFragment;
import com.shray.myapplication.fragment.ThirdFragment;
import com.shray.myapplication.model.GenericTab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.TLTab)
    TabLayout TLTab;
    @BindView(R.id.VPTab)
    ViewPager VPTab;
    private List<GenericTab> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view_pager);
        ButterKnife.bind(this);

        setupViewPager(VPTab);
        TLTab.setupWithViewPager(VPTab);
        for(int i=0;i<TLTab.getTabCount();i++)
            TLTab.getTabAt(i).setIcon(list.get(i).getDrawable());

    }

    private void setupViewPager(ViewPager vpTab) {
        list.add(new GenericTab(new FirstFragment(),"First",R.drawable.ic_arrow));
        list.add(new GenericTab(new ScondFragment(),"Second",R.drawable.ic_downarrow));
        list.add(new GenericTab(new ThirdFragment(),"Third",R.drawable.ic_googleplus));
        ViewPagerTabAdapter adapter = new ViewPagerTabAdapter(getFragmentManager(), list);
        vpTab.setAdapter(adapter);
    }


}
