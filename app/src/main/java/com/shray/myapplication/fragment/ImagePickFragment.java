package com.shray.myapplication.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shray.myapplication.R;

import java.io.File;
import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagePickFragment extends DialogFragment {

    @BindView(R.id.BtnImagePickCamFrag) Button cameraPick;
    @BindView(R.id.BtnImagepickGalFrag) Button galleryPick;
    private final static int CAM=1,GAL=2;


    public ImagePickFragment() {
        // Required empty public constructor
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
        switch (requestCode){

        }
    }

    private void createDirectoryAndSaveFile(Bitmap imageToSave, String fileName) {

        File direct = new File(Environment.getExternalStorageDirectory() + "/DirName");

        if (!direct.exists()) {
            File wallpaperDirectory = new File("/sdcard/DirName/");
            wallpaperDirectory.mkdirs();
        }

        File file = new File(new File("/sdcard/DirName/"), fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        imageFolderName= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Learning/downsampled_image_folder";
//        folderPath=new File(imageFolderName);
//        if (!folderPath.exists())
//        {
//            folderPath.mkdirs();
//        }
    }
}
