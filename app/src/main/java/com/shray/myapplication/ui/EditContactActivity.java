package com.shray.myapplication.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.shray.myapplication.R;
import com.shray.myapplication.database.DatabaseHandler;
import com.shray.myapplication.model.Contact;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditContactActivity extends AppCompatActivity {

    private Uri dp;
    private static final int IMAGE = 1;
    @BindView(R.id.IVEditContact) ImageView IVDp;
    @BindView(R.id.ETEditContactName) EditText name;
    @BindView(R.id.ETEditContactPhone) EditText phoneNo;
    @BindView(R.id.BtnEditContact) Button updatechanges;
    @BindView(R.id.BtnDeleteContact) Button deleteContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        ButterKnife.bind(this);

        Intent getIntend=getIntent();
        int key=getIntend.getIntExtra("key",0);


        final DatabaseHandler db = new DatabaseHandler(this);
        final Contact contact=db.getContact(key);
        dp=Uri.parse(contact.getDp());
        Picasso.with(this).load(dp).into(IVDp);
        name.setText(contact.getName());
        phoneNo.setText(contact.getPhoneNo());


        IVDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imagePick=new Intent(Intent.ACTION_PICK);
                imagePick.setType("image/*");
                startActivityForResult(imagePick,IMAGE);
            }
        });

        updatechanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact.setName(name.getText().toString().trim());
                contact.setPhoneNo(phoneNo.getText().toString().trim());
                contact.setDp(dp.toString());
                db.updateContact(contact);
                Toast.makeText(EditContactActivity.this,"Contact Updated",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditContactActivity.this,ContactsFetchActivity.class));
                finish();
            }
        });

        deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteContact(contact);
                Toast.makeText(EditContactActivity.this,"Contact Deleted",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditContactActivity.this,ContactsFetchActivity.class));
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IMAGE&&resultCode==RESULT_OK){
            dp=data.getData();
            Picasso.with(EditContactActivity.this).load(dp).into(IVDp);
        }
    }

}
