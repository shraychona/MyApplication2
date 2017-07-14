package com.shray.myapplication.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shray.myapplication.R;
import com.shray.myapplication.ui.TenthActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user12 on 13/7/17.
 */

public class A10Adapter extends RecyclerView.Adapter<A10Adapter.MyViewHolder> {

    private static final int LOADER = 2;
    private static final int ELEMENTS = 1;
    TenthActivity object;
    int count=1;
    Context context;
    List<String> list;
    List<String> list2;


    public A10Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        list2=list.subList(0,11);
    }



    @Override
    public int getItemViewType(int position) {
        if(position==list2.size()) {
            return LOADER;
        }
        else {
            return ELEMENTS;
        }
    }

    

    @Override
    public A10Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType==LOADER){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_a10_header,parent,false);
        }
        else {
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_a10_text,parent,false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final A10Adapter.MyViewHolder holder, final int position) {
        if(holder.getItemViewType()==LOADER){
            if(moreItems(position)) {
                holder.progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.progressBar.setVisibility(View.GONE);
//
                        if ((list2.size()+10)<=list.size()){
                            list2=list.subList(0,(position+10));
                        }
                        else {
                            int diff=list.size()-list2.size()-1;
                            list2=list.subList(0,diff);
                        }

                    }
                }, 3000);
            }
        }
        if (holder.getItemViewType() == ELEMENTS) {
                holder.TVData.setText(list2.get(position));
        }
    }

    private boolean moreItems(int position) {
        if(list2.size()>=list.size()){
            return false;
        }
        else {
            //notifyDataSetChanged();
            return true;
        }
    }


    @Override
    public int getItemCount() {
        return list2.size()+1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        TextView TVData;
//        @BindView(R.id.PBRowA10) ProgressBar progressBar;
//        @BindView(R.id.TVRowA10) TextView TVData;
        public MyViewHolder(View itemView) {
            super(itemView);
            progressBar= (ProgressBar) itemView.findViewById(R.id.PBRowA10);
            TVData= (TextView) itemView.findViewById(R.id.TVRowA10);
//            ButterKnife.bind(this,itemView);
        }
    }

}
