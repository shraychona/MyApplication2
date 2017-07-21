package com.shray.myapplication.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shray.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagePickFragment extends android.app.DialogFragment {

    @BindView(R.id.BtnImagePickCamFrag) Button cameraPick;
    @BindView(R.id.BtnImagepickGalFrag) Button galleryPick;
    private final static int CAM=1,GAL=2;


    public ImagePickFragment() {
        // Required empty public constructor
    }

    public static ImagePickFragment newInstance(String title){
        ImagePickFragment frag =new ImagePickFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_image_pick, container, false);
        ButterKnife.bind(this,view);

        cameraPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, CAM);
            }
        });

        galleryPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imagePick=new Intent(Intent.ACTION_PICK);
                imagePick.setType("image/*");
                startActivityForResult(imagePick,GAL);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri;
        switch (requestCode){

            case CAM:
                if(resultCode==(-1)){
                    uri=data.getData();
                }
                break;
            case GAL:
                if(resultCode==(-1)){
                    uri=data.getData();
                }
        }

    }

}
