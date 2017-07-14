package com.shray.myapplication.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shray.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdFragment extends android.app.Fragment {

    @BindView(R.id.TVThirdText)
    TextView text;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_third, container, false);
        ButterKnife.bind(this,view);
        text.setText("Third Text");
        return view;
    }

}
