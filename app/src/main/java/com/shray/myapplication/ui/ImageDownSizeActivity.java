package com.shray.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageDownSizeActivity extends BaseActivity {

    @BindView(R.id.IVImageDownSize) ImageView imageView;
    @BindView(R.id.BtnImagePick) Button BtnImagePicker;
    @BindView(R.id.BtnImageDown) Button BtnConvertImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_down_size);
        ButterKnife.bind(this);

        BtnImagePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
