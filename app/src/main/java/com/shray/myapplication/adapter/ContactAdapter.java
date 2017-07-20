package com.shray.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shray.myapplication.R;
import com.shray.myapplication.model.Contact;
import com.shray.myapplication.ui.ContactsFetchActivity;
import com.shray.myapplication.ui.EditContactActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user12 on 19/7/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    List<Contact> contactList=new ArrayList<>();
    Context context;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Contact contact=contactList.get(position);
        holder.name.setText(contact.getName());
        holder.phoneNo.setText(contact.getPhoneNo());
//        holder.dp.setImageURI(Uri.parse(contact.getDp()));
        Picasso.with(context).load(Uri.parse(contact.getDp())).resize(50,50).into(holder.dp);

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, EditContactActivity.class);
                intent.putExtra("key",contactList.get(position).getKeyId());
                context.startActivity(intent);
                ((ContactsFetchActivity) context).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.TVRowContactName) TextView name;
        @BindView(R.id.TVRowContactPhoneNo) TextView phoneNo;
        @BindView(R.id.IVRowContactDP) ImageView dp;
        @BindView(R.id.IVEdit) ImageView edit;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
