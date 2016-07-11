package com.example.sebastian.cvmaker.CV.create;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.sebastian.cvmaker.CV.Creator.customDialog.ListSelectionDialog;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

public class CV_creator extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_creator);


        ListSelectionDialog Cv_catregory = new ListSelectionDialog();

        Cv_catregory.show(getFragmentManager(), "chooselist");


    }


    public void onUserSelectValue(ArrayList<String> choose) {
        for (String x : choose)
            System.out.println(x);
    }









}
