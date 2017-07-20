package com.shray.myapplication.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;
import com.shray.myapplication.adapter.ContactAdapter;
import com.shray.myapplication.database.DatabaseHandler;
import com.shray.myapplication.model.Contact;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsFetchActivity extends BaseActivity {

    @BindView(R.id.RVShowContacts) RecyclerView RVShowContacts;
    @BindView(R.id.BtnAddContacts) Button addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_fetch);
        ButterKnife.bind(this);

        getLocalContacts();



        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContactsFetchActivity.this,AddContactActivity.class));
            }
        });

    }


    private void getLocalContacts(){
        DatabaseHandler db = new DatabaseHandler(this);
//        db.addContact(new Contact(1,"Ravi", "9100000000",R.drawable.ic_facebookcontact));
//        db.addContact(new Contact(2,"Srinivas", "9199999999",R.drawable.ic_googlepluscontact));
//        db.addContact(new Contact(3,"Tommy", "9522222222",R.drawable.ic_facebookcontact));
//        db.addContact(new Contact(4,"Karthik", "9533333333",R.drawable.ic_googlepluscontact));

        List<Contact> contacts = db.getAllContacts();

        ContactAdapter contactAdapter = new ContactAdapter(ContactsFetchActivity.this, contacts);
        RVShowContacts.setLayoutManager(new LinearLayoutManager(ContactsFetchActivity.this,
                LinearLayoutManager.VERTICAL,false));
        RVShowContacts.setAdapter(contactAdapter);

    }

}
