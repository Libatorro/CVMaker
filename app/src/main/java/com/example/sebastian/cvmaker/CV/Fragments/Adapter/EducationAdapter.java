package com.example.sebastian.cvmaker.CV.Fragments.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastian.cvmaker.CV.Fragments.Models.EduciatonModel;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2016-07-03.
 */
public class EducationAdapter extends ArrayAdapter<EduciatonModel> {

    public EducationAdapter(Context context, int resource, ArrayList<EduciatonModel> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater sebIflneter = LayoutInflater.from(getContext());
        View CustomView = sebIflneter.inflate(R.layout.customadapter_eduk, parent, false);

        String signleRow = getItem(position).getSchoolName();
        TextView textView_adapter = (TextView) CustomView.findViewById(R.id.textView_adapter);
        ImageView imageView_adapter = (ImageView) CustomView.findViewById(R.id.imageView_adapter);

        textView_adapter.setText(signleRow);


        return CustomView;
    }


}
