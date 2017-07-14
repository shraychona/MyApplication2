package com.shray.myapplication.ui;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shray.myapplication.R;
import com.shray.myapplication.adapter.A10Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TenthActivity extends AppCompatActivity {

    @BindView(R.id.RVA10)
    RecyclerView recyclerView;
    List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        ButterKnife.bind(this);

        populateList();


        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        A10Adapter adapter=new A10Adapter(this,list);
        recyclerView.setAdapter(adapter);

    }

    public void populateList() {
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
        list.add("Last");

    }

}
