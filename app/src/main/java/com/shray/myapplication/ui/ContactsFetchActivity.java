package com.shray.myapplication.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
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

import com.shray.myapplication.R;
import com.shray.myapplication.adapter.ContactAdapter;
import com.shray.myapplication.database.DatabaseHandler;
import com.shray.myapplication.model.Contact;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsFetchActivity extends AppCompatActivity {

    @BindView(R.id.BtnShowContacts)
    TextView BtnShowContacts;
    @BindView(R.id.BtnShowLocalContacts)
    Button BtnShowLocalContacts;
    @BindView(R.id.RVShowContacts)
    RecyclerView RVShowContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_fetch);
        ButterKnife.bind(this);

        BtnShowContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllContacts();
            }
        });

        BtnShowLocalContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              getLocalContacts();
            }
        });


        RVShowContacts.setLayoutManager(new LinearLayoutManager(ContactsFetchActivity.this,
                LinearLayoutManager.VERTICAL,false));


    }

    private void getLocalContacts(){
        DatabaseHandler db = new DatabaseHandler(this);
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        List<Contact> contacts = db.getAllContacts();

        ContactAdapter contactAdapter = new ContactAdapter(ContactsFetchActivity.this, contacts);
        RVShowContacts.setAdapter(contactAdapter);

        for (Contact cn : contacts) {
            String log = "Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNo();
        }

    }




    private void getAllContacts() {
        List<Contact> contactVOList = new ArrayList();
        Contact contactVO;
        ProgressDialog progressdialog = new ProgressDialog(ContactsFetchActivity.this);
        progressdialog.setMessage("Please Wait....");
        progressdialog.show();


        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    contactVO = new Contact();
                    contactVO.setName(name);

                    Cursor phoneCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id},
                            null);
                    if (phoneCursor.moveToNext()) {
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        contactVO.setPhoneNo(phoneNumber);
                    }

                    phoneCursor.close();

                    Cursor emailCursor = contentResolver.query(
                            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (emailCursor.moveToNext()) {
                        String emailId = emailCursor.getString(emailCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                    }
                    contactVOList.add(contactVO);
                }
            }

            ContactAdapter contactAdapter = new ContactAdapter(ContactsFetchActivity.this, contactVOList);
            RVShowContacts.setAdapter(contactAdapter);
            progressdialog.dismiss();

        }
    }
}
