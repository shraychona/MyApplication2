package com.shray.myapplication.ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;
import com.shray.myapplication.adapter.ImageAdapter;
import com.shray.myapplication.helper.DividerItemDecoration;
import com.shray.myapplication.model.ImageModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

public class GridActivity extends BaseActivity {

    ImageAdapter adapter;
    @BindView(R.id.RVGrid) RecyclerView RVGrid;
    public final int HEADER = 1, IMG = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.bind(this);

        createObjects();
        adapter=new ImageAdapter(this,createObjects());

        GridLayoutManager glm = new GridLayoutManager(this, 4);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(adapter.getItemViewType(position)){
                    case HEADER:
                        return 4;
                    case IMG:
                        return 1;
                    default:
                        return -1;
                }
            }
        });
        RVGrid.setLayoutManager(glm);
        RecyclerView.ItemDecoration dividerItemDecoration = null;
        dividerItemDecoration = new DividerItemDecoration(getDrawable(R.drawable.item_divider));
        RVGrid.addItemDecoration(dividerItemDecoration);
        RVGrid.setAdapter(adapter);

    }


    private List<ImageModel> createObjects() {

        String date="1 May";
        String date2="2 May";
        String date3="3 May";

        List<ImageModel> imageModels=new ArrayList<>();
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_whatsapp),true));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_whatsapp),true));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date2,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_whatsapp),true));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_messanger)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_whatsapp)));
        imageModels.add(new ImageModel(date3,getDrawable(R.drawable.ic_messanger)));




        return imageModels;
    }
}
