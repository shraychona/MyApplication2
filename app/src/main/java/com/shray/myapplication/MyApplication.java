package com.shray.myapplication;

import android.app.Application;

import com.shray.myapplication.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by shray on 04-07-2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/ProximaSemibold.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
