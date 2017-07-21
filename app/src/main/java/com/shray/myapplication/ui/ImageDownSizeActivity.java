package com.shray.myapplication.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;
import com.shray.myapplication.helper.DownsizeImage;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

import static junit.framework.Assert.assertEquals;

public class ImageDownSizeActivity extends BaseActivity {

    private final static int CAM=1,GAL=2;
    String imageFolderName;
    File folderPath;
    String imageName;
    File imagePath;
    Uri uri;

    private File file;

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
                fetchImage();
            }
        });

        BtnConvertImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downSizeImage();
            }
        });
    }


    public void fetchImage(){

        createFolder();
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setItems(getResources().getStringArray(R.array.select_image), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        camIntent();
                        dialogInterface.dismiss();
                        break;
                    case 1:
                        galIntent();
                        dialogInterface.dismiss();
                        break;
                    case 2:
                        dialogInterface.dismiss();
                        break;
                }
            }
        });
        alert.show();
    }

    private void galIntent() {
        Intent intentImage=new Intent();
        intentImage.setType("image/*");
        intentImage.setAction(Intent.ACTION_PICK);
        Intent chooserIntent=Intent.createChooser(intentImage,"Select profile via");
        startActivityForResult(chooserIntent,GAL);
    }

    private void camIntent() {
        Intent intentCamera=new Intent();
        intentCamera.setAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        imageName="Img"+System.currentTimeMillis()+".jpg";
        imagePath=new File(folderPath,imageName);
        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagePath));
        startActivityForResult(intentCamera, CAM);
    }

    private void createFolder() {
        imageFolderName= Environment.getExternalStorageDirectory().getAbsolutePath()+"/MyApplication/downsampled images";
        folderPath=new File(imageFolderName);
        if (!folderPath.exists())
        {
            folderPath.mkdirs();
        }
    }

    private void downSizeImage() {
        Bitmap finalImage=DownsizeImage.decodeSampledBitmapFromFile(file,250,250);
        imageView.setImageBitmap(finalImage);
//        Picasso.with(ImageDownSizeActivity.this).load().into(imageView);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAM:
                if (resultCode==RESULT_OK){
                    file = new File(folderPath, imageName);
                    Picasso.with(ImageDownSizeActivity.this).load(file).into(imageView);

                }
                break;
            case GAL:
                if (resultCode==RESULT_OK){
                    uri=data.getData();
//
//                    file = new File(folderPath, imageName);
//                    File auxFile = new File(uri.getPath());
//                    assertEquals(file.getAbsolutePath(), auxFile.getAbsolutePath());

                    Picasso.with(ImageDownSizeActivity.this).load(uri).into(imageView);
                }
                break;
        }


    }
}
