package com.shray.myapplication.model;

import android.graphics.Bitmap;

/**
 * Created by user12 on 19/7/17.
 */

public class Contact {
    private String name,phoneNo;
    private Bitmap dp;
    private int keyId;

    public Contact(int keyId,String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.keyId = keyId;
    }

    public Contact(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.keyId=1;
        this.dp=null;
    }

    public Contact() {
    }

    public Contact(String name, String phoneNo, Bitmap dp) {

        this.name = name;
        this.phoneNo = phoneNo;
        this.dp = dp;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
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

    public Bitmap getDp() {
        return dp;
    }

    public void setDp(Bitmap dp) {
        this.dp = dp;
    }
}
