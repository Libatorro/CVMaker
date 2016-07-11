package com.example.sebastian.cvmaker.CV.Fragments.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sebastian.cvmaker.CV.Fragments.Models.LangueModel;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2016-07-05.
 */
public class LangueAdapter extends ArrayAdapter<LangueModel> {
    public String getSpinnerValue() {
        return SpinnerValue;
    }

    private String SpinnerValue;

    public LangueAdapter(Context context, int resource, ArrayList<LangueModel> objects) {
        super(context, resource, objects);


    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater sebIflneter = LayoutInflater.from(getContext());
        View CustomView = sebIflneter.inflate(R.layout.customadapter_langue,parent,false);
ArrayAdapter<CharSequence> spinner_Adapter = ArrayAdapter.createFromResource(getContext(),R.array.langue_type,android.R.layout.simple_spinner_item);
            spinner_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        String signleRow = getItem(position).getLangue();
        String singleSpinner=getItem(position).getSpinnerValue();
        TextView textView_adapter = (TextView) CustomView.findViewById(R.id.textView_Adapter_langue);
        Spinner spinner= (Spinner)CustomView.findViewById(R.id.spinner_Adapter_langue);
        spinner.setAdapter(spinner_Adapter);
        int spinnerPosition = spinner_Adapter.getPosition(singleSpinner);
        spinner.setSelection(spinnerPosition);


spinner.setClickable(false);
        spinner.setEnabled(false);
        textView_adapter.setText(signleRow);
        if(signleRow=="DODAJ") {

spinner.setVisibility(View.GONE);
            ImageView im=(ImageView)CustomView.findViewById(R.id.imageView_Adapter_langue);
            im.setVisibility(View.GONE);
            textView_adapter.setTextColor(Color.RED);
            textView_adapter.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        }


        return  CustomView;
    }

}
