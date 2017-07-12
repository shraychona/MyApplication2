package com.shray.myapplication.ui;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;
import com.shray.myapplication.adapter.RecyclerAdapter;
import com.shray.myapplication.helper.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerActivity extends BaseActivity {
    @BindView(R.id.RV1) RecyclerView RV1;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        List<String> list=new ArrayList<>();
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");


        List<String> list2=new ArrayList<>();
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");
        list2.add("abc");
        list2.add("123");
        list2.add("sdfsf");
        list2.add("ertdrf");
        list2.add("vfghjg");
        list2.add("ytutdf");


        RV1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter=new RecyclerAdapter(this,list,list2);

        RecyclerView.ItemDecoration dividerItemDecoration = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            dividerItemDecoration = new DividerItemDecoration(getDrawable(R.drawable.item_divider));
        }
        else {
            dividerItemDecoration = new DividerItemDecoration(getResources().getDrawable(R.drawable.item_divider));
        }
        RV1.addItemDecoration(dividerItemDecoration);
//        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
//        itemAnimator.setRemoveDuration(7000);
//        RV1.setItemAnimator(itemAnimator);

        RV1.setAdapter(adapter);
    }
}
