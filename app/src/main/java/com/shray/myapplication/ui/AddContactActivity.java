package com.shray.myapplication.ui;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;
import com.shray.myapplication.database.DatabaseHandler;
import com.shray.myapplication.model.Contact;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddContactActivity extends BaseActivity {

    private Uri dp;
    private static final int IMAGE = 1;
    @BindView(R.id.IVNewContactdp) ImageView IVDp;
    @BindView(R.id.ETNewContactName) EditText ETName;
    @BindView(R.id.ETNewContactPhoneNo) EditText ETPhoneNo;
    @BindView(R.id.BtnNewContactSave) Button BtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        ButterKnife.bind(this);
        final DatabaseHandler db = new DatabaseHandler(this);

        IVDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imagePick=new Intent(Intent.ACTION_PICK);
                imagePick.setType("image/*");
                startActivityForResult(imagePick,IMAGE);
            }
        });

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ETName.getText().toString().trim();
                String phoneNo=ETPhoneNo.getText().toString().trim();
                if(name!=null&&phoneNo!=null&&dp!=null){
                    Contact contact=new Contact(name,phoneNo,dp.toString());
                    db.addContact(contact);
                    Toast.makeText(AddContactActivity.this,"Contact Added ",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddContactActivity.this,ContactsFetchActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(AddContactActivity.this,"Enter Details Properly ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IMAGE&&resultCode==RESULT_OK){
            dp=data.getData();
            Picasso.with(AddContactActivity.this).load(dp).into(IVDp);
        }
    }
}
