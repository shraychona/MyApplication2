package com.shray.myapplication.model;

import android.graphics.Bitmap;

/**
 * Created by user12 on 19/7/17.
 */

public class Contact {
    private String name,phoneNo;
    private String dp;
    private int keyId;

    public Contact(String name, String phoneNo, String dp) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.dp = dp;
    }

    public Contact( int keyId, String name, String phoneNo, String dp) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.dp=dp;
        this.keyId = keyId;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }
}
