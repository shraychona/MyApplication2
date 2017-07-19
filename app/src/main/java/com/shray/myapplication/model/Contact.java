package com.shray.myapplication.model;

import android.graphics.Bitmap;

/**
 * Created by user12 on 19/7/17.
 */

public class Contact {
    private String name,phoneNo;
    private int dp;
    private int keyId;

    public Contact(int keyId,String name, String phoneNo, int dp) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.dp = dp;
        this.keyId = keyId;
    }

    public Contact( int keyId, String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
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

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }
}
