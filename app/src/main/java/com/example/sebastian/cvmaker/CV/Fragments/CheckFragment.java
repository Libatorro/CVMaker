package com.example.sebastian.cvmaker.CV.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2016-07-09.
 */
public class CheckFragment extends Fragment {
    private View view;

    RadioButton[] arryRadio;


    public CheckFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_cv_creator, container, false);
        arryRadio = new RadioButton[7];


            arryRadio[0]=(RadioButton)view.findViewById(R.id.radioButtonMP1);
            arryRadio[1]=(RadioButton)view.findViewById(R.id.radioButtonMP2);
            arryRadio[2]=(RadioButton)view.findViewById(R.id.radioButtonMP3);
            arryRadio[3]=(RadioButton)view.findViewById(R.id.radioButtonMP4);
            arryRadio[4]=(RadioButton)view.findViewById(R.id.radioButtonMP5);
            arryRadio[5]=(RadioButton)view.findViewById(R.id.radioButtonMP6);
            arryRadio[6]=(RadioButton)view.findViewById(R.id.radioButtonMP7);
        ArrayList<Boolean> bb= NavigationDr.booleanArrayList;
        for (int i = 0; i <6 ; i++) {

            arryRadio[i].setChecked(bb.get(i));
        }



        return view;

    }
}
