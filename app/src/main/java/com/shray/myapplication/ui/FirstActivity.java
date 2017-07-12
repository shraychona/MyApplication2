package com.shray.myapplication.ui;

import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shray.myapplication.R;

public class FirstActivity extends AppCompatActivity {
    private EditText ETEnterData;
    private Button BtnClickMe;
    private TextView TVFinalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ETEnterData= (EditText) findViewById(R.id.ETEnterData);
        BtnClickMe= (Button) findViewById(R.id.BtnClickMe);
        TVFinalData= (TextView) findViewById(R.id.TVFinalData);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            BtnClickMe.setBackground(getResources().getDrawable(R.drawable.ripple_effect));
        }

        BtnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=ETEnterData.getText().toString().trim();
                TVFinalData.setText(data);
            }
        });
        
    }
}
