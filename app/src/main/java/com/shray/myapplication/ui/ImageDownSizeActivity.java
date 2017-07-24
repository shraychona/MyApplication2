package com.shray.myapplication.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.BuildConfig;
import com.shray.myapplication.R;
import com.shray.myapplication.helper.DownsizeImage;
import com.shray.myapplication.helper.GeneralFunctions;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static junit.framework.Assert.assertEquals;

public class ImageDownSizeActivity extends BaseActivity implements
        DownsizeImage.SampledImageAsyncResp {

    private final static int CAM=1,GAL=2;
    private String picturePath, imagesDirectory;
    private boolean isCameraOptionSelected;

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
                fetchImage();
               // downSizeImage();
            }
        });
    }


    public void fetchImage(){

     //   createFolder();
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
        startActivityForResult(new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GAL);
    }

    private void camIntent() {
        Intent takePictureIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE);
        File file = null;
        imagesDirectory=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Sampled Images";
        try {
            file = GeneralFunctions.setUpImageFile(imagesDirectory);
            picturePath = file.getAbsolutePath();

            Uri outputUri = FileProvider
                    .getUriForFile(this, BuildConfig.APPLICATION_ID , file);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                ClipData clip = ClipData.newUri(getContentResolver(),
                        "A photo", outputUri);

                takePictureIntent.setClipData(clip);
                takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            } else {
                List<ResolveInfo> resInfoList = getPackageManager()
                        .queryIntentActivities(takePictureIntent,
                                PackageManager.MATCH_DEFAULT_ONLY);

                for (ResolveInfo resolveInfo : resInfoList) {
                    String packageName = resolveInfo.activityInfo.packageName;
                    grantUriPermission(packageName, outputUri,
                            Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            picturePath = null;
        }
        startActivityForResult(takePictureIntent, CAM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && (requestCode == GAL ||
                requestCode == CAM)) {
            boolean isGalleryImage = false;
            if (requestCode == GAL) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                picturePath = cursor.getString(columnIndex);
                cursor.close();
                isGalleryImage = true;
            }

            new DownsizeImage(this).execute(picturePath, imagesDirectory,
                    String.valueOf(isGalleryImage),
                    String.valueOf((int) getResources()
                            .getDimension(R.dimen.image_downsample_size)));
        }
    }

    @Override
    public void onSampledImageAsyncPostExecute(File file) {
        Picasso.with(this).load(file).into(imageView);
    }

}
