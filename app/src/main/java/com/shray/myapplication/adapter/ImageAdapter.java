package com.shray.myapplication.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.shray.myapplication.R;
import com.shray.myapplication.model.ImageModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shray on 10-07-2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    public Context context;
    private List<ImageModel> imageModels;
    public final int HEADER = 1, IMG = 2;
    private int lastPosition = -1;

    public ImageAdapter(Context context, List<ImageModel> imageModels) {
        this.context = context;
        this.imageModels = imageModels;
    }

    @Override
    public int getItemViewType(int position) {
        if (imageModels.get(position).getFlag() == true) {
            return HEADER;
        } else {
            return IMG;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_date, parent, false);
            return new MyViewHolder(view1);
        }
        else {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_image_child, parent, false);
            return new MyViewHolder(view2);
        }
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageModel imageModel = imageModels.get(position);
        setAnimation(holder.itemView, position);
        if(holder.getItemViewType()==HEADER) {
            holder.date.setText(imageModel.getDate());
        }
        else {
            holder.IVImages.setImageDrawable(imageModel.getImages());
        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return imageModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        ImageView IVImages;
//        @BindView(R.id.TVRowDate) TextView date;
//        @BindView(R.id.IVRowImageChild) ImageView IVImages;

        public MyViewHolder(View itemView) {
            super(itemView);
//            ButterKnife.bind(this, itemView);
            date= (TextView) itemView.findViewById(R.id.TVRowDate);
            IVImages= (ImageView) itemView.findViewById(R.id.IVRowImageChild);
        }
    }
}
