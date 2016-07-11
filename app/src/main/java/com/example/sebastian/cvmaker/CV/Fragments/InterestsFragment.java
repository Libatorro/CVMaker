package com.example.sebastian.cvmaker.CV.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InterestsFragment extends Fragment {
    public static final String source = "IF";
    private static boolean context_Flag = false;
    View W;
    TextView IntestView;
    ArrayList<String> stringArrayList = new ArrayList<>();

    public InterestsFragment() {
        // Required empty public constructor
    }

    public static InterestsFragment newInstans(ArrayList<String> interestsModel) {


        InterestsFragment interestsFragment = new InterestsFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(source, interestsModel);
        interestsFragment.setArguments(args);

        context_Flag = true;


        return interestsFragment;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (context_Flag) {
            stringArrayList = getArguments().getStringArrayList(source);


        }
        W = inflater.inflate(R.layout.fragment_interests, container, false);
        IntestView = (TextView) W.findViewById(R.id.editText_Intress);
        for (String x : stringArrayList)
            IntestView.append(x);


        return W;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context_Flag)
            return;
        NavigationDr callingActivity = (NavigationDr) getActivity();
        ArrayList<String> abc = new ArrayList<>();


        abc.add(IntestView.getText().toString());

        callingActivity.onUserSelectValue(abc, source);


        super.onDetach();
    }
}
