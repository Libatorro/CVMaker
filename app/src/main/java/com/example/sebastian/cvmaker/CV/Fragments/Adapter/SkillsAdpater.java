package com.example.sebastian.cvmaker.CV.Fragments.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastian.cvmaker.CV.Fragments.Models.SkillsModel;
import com.example.sebastian.cvmaker.R;

import java.util.List;

/**
 * Created by Sebastian on 2016-07-06.
 */
public class SkillsAdpater extends ArrayAdapter<SkillsModel> {

    TextView    [] textView_skills_Adapter;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater Iflneter = LayoutInflater.from(getContext());
        final View CustomView = Iflneter.inflate(R.layout.custom_skill_adapter,parent,false);
        textView_skills_Adapter= new TextView[5];
        textView_skills_Adapter[0]=(TextView)CustomView.findViewById(R.id.textView_skills_Adapter);
        textView_skills_Adapter[1]=(TextView)CustomView.findViewById(R.id.textView_skills_Adapter_1);
        textView_skills_Adapter[2]=(TextView)CustomView.findViewById(R.id.textView_skills_Adapter_2);
        textView_skills_Adapter[3]=(TextView)CustomView.findViewById(R.id.textView_skills_Adapter_3);
        textView_skills_Adapter[4]=(TextView)CustomView.findViewById(R.id.textView_skills_Adapter_4);

        textView_skills_Adapter[0].setText(getItem(position).getSkill_titile());


        if(getItem(position).getSkill_titile()=="DODAJ")
            for (int i = 1; i < 5; i++) {
                textView_skills_Adapter[i].setVisibility(View.GONE);
            }
        else {
            int i = 1;
            for (String x : getItem(position).getSkill_values()) {
                textView_skills_Adapter[i].setText(x);
                i++;
            }


            for(TextView x :textView_skills_Adapter) {
                if (!(x.getText().length() >0)) {
                    x.setVisibility(View.GONE);

                }
            }


        }











return CustomView;

    }

    public SkillsAdpater(Context context, int resource, List<SkillsModel> objects) {
        super(context, resource, objects);
    }

}
