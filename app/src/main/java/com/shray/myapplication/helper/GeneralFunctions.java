package com.shray.myapplication.helper;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by user12 on 24/7/17.
 */

public class GeneralFunctions {

    private static final String JPEG_FILE_PREFIX = "IMG_";
    private static final String JPEG_FILE_SUFFIX = ".jpg";


    public static File setUpImageFile(String directory) throws IOException{
         File imageFile=null;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            File storageDir=new File(directory);
            if (null!=storageDir){
                if (!storageDir.mkdirs()){
                    if (!storageDir.exists()) {
                        Log.d("CameraSample", "failed to create directory");
                        return null;
                    }
                }
            }
            imageFile = File.createTempFile(JPEG_FILE_PREFIX
                            + System.currentTimeMillis() + "_",
                    JPEG_FILE_SUFFIX, storageDir);
        }
        return imageFile;
    }
}
