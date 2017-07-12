package com.shray.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;
import com.shray.myapplication.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends BaseActivity {
    @BindView(R.id.LV) ListView LV;
    private ListAdapter adapter;
    private ArrayAdapter<String> defaultAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        List<String> list=new ArrayList<>();
        list.add("English");
        list.add("Maths");
        list.add("Java");
        list.add("Android");
        list.add("Python");
        list.add("JS");

        defaultAdapter=new ArrayAdapter<>(this,android.R.layout.activity_list_item,android.R.id.text1,list);
        LV.setAdapter(defaultAdapter);

    }
}
