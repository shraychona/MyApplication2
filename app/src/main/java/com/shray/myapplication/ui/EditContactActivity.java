package com.shray.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.shray.myapplication.R;
import com.shray.myapplication.database.DatabaseHandler;
import com.shray.myapplication.model.Contact;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditContactActivity extends AppCompatActivity {

    @BindView(R.id.IVEditContact)
    ImageView dp;
    @BindView(R.id.ETEditContactName)
    EditText name;
    @BindView(R.id.ETEditContactPhone) EditText phoneNo;
    @BindView(R.id.BtnEditContact)
    Button updatechanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        ButterKnife.bind(this);

        final DatabaseHandler db = new DatabaseHandler(this);
        final Contact contact=db.getContact(2);
        Picasso.with(this).load(R.drawable.ic_facebookcontact).resize(50,50).into(dp);
        name.setText(contact.getName());
        phoneNo.setText(contact.getPhoneNo());

        updatechanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact.setName(name.getText().toString().trim());
                contact.setPhoneNo(phoneNo.getText().toString().trim());
                db.updateContact(contact);
            }
        });
    }
}
