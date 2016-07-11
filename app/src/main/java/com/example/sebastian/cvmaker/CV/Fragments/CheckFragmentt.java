package com.example.sebastian.cvmaker.CV.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;


public class CheckFragmentt extends Fragment {


    RadioButton[] arryRadio;
    private View view;

    public CheckFragmentt() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckFragmentt.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckFragmentt newInstance(String param1, String param2) {
        CheckFragmentt fragment = new CheckFragmentt();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_check_fragmentt, container, false);

        arryRadio = new RadioButton[7];


        arryRadio[0] = (RadioButton) view.findViewById(R.id.radioButtonMP1);
        arryRadio[1] = (RadioButton) view.findViewById(R.id.radioButtonMP2);
        arryRadio[2] = (RadioButton) view.findViewById(R.id.radioButtonMP3);
        arryRadio[3] = (RadioButton) view.findViewById(R.id.radioButtonMP4);
        arryRadio[4] = (RadioButton) view.findViewById(R.id.radioButtonMP5);
        arryRadio[5] = (RadioButton) view.findViewById(R.id.radioButtonMP6);
        arryRadio[6] = (RadioButton) view.findViewById(R.id.radioButtonMP7);
        ArrayList<Boolean> bb = NavigationDr.booleanArrayList;
        for (int i = 0; i < 6; i++) {
            if (bb.size() > i)
                arryRadio[i].setChecked(bb.get(i));
        }

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }
}

