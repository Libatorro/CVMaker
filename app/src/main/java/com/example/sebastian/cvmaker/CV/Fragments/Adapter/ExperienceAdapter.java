package com.example.sebastian.cvmaker.CV.Fragments.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastian.cvmaker.CV.Fragments.Models.EduciatonModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.ExperienceModel;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2016-07-04.
 */
public class ExperienceAdapter extends ArrayAdapter<ExperienceModel> {
    public ExperienceAdapter(Context context, int resource, List<ExperienceModel> objects) {
        super(context,resource,objects);

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater sebIflneter = LayoutInflater.from(getContext());
        View CustomView = sebIflneter.inflate(R.layout.customadapter_experience,parent,false);

        String signleRow = getItem(position).getJob_name();



        TextView textView_adapter = (TextView) CustomView.findViewById(R.id.textView_Experience);
        ImageView imageView_adapter = (ImageView) CustomView.findViewById(R.id.imageViewExperience);

        textView_adapter.setText(signleRow);




        return  CustomView;
    }
}
