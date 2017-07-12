package com.shray.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shray.myapplication.R;
import com.shray.myapplication.ui.ContactUs;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by shray on 07-07-2017.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    List<String> list;

    public ListAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView= LayoutInflater.from(context).inflate(R.layout.list_view,parent,false);
//        TextView tv= (TextView) convertView.findViewById(R.id.TVName);
//        tv.setText(list.get(position));
        return convertView;
    }
}
