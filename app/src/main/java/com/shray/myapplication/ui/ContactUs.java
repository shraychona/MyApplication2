package com.shray.myapplication.ui;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.shray.myapplication.BaseActivity;
import com.shray.myapplication.R;

public class ContactUs extends BaseActivity {
    private String[] subjects = {"English", "Maths","Java","Android","Python","JS"};
    private TextView tv;
    ListPopupWindow listPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        tv = (TextView) findViewById(R.id.popUpTV);
        listPopupWindow =new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<>(ContactUs.this,R.layout.support_simple_spinner_dropdown_item,subjects));
        listPopupWindow.setAnchorView(tv);
        listPopupWindow.setModal(true);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPopupWindow.show();
            }
        });

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(subjects[position]);
                listPopupWindow.dismiss();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
