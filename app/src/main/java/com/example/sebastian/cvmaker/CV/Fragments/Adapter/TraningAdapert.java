package com.example.sebastian.cvmaker.CV.Fragments.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastian.cvmaker.CV.Fragments.Models.TraningModel;
import com.example.sebastian.cvmaker.CV.Fragments.TrainingFragment;

import com.example.sebastian.cvmaker.CV.ImageSizer;
import com.example.sebastian.cvmaker.R;

import java.util.List;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Sebastian on 2016-07-05.
 */
public class TraningAdapert extends ArrayAdapter<TraningModel> {
    public TraningAdapert(Context context, int resource, List<TraningModel> objects) {
        super(context, resource, objects);

    }




    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater sebIflneter = LayoutInflater.from(getContext());
        final View CustomView = sebIflneter.inflate(R.layout.custom_traning_adapter,parent,false);


        String signleRow = getItem(position).getName_Traning();
        String picturePath= getItem(position).getUrl_for_cerfytication();



        TextView textView_adapter = (TextView) CustomView.findViewById(R.id.TextView_Traing_adapter);

        ImageView imageView_adapter= (ImageView)CustomView.findViewById(R.id.imageView_traning_adapter);
if(signleRow=="Dodaj") {

    imageView_adapter.setVisibility(View.GONE);

}
if(picturePath.isEmpty()) {
    imageView_adapter.setVisibility(View.GONE);
}else
    imageView_adapter.setImageBitmap(ImageSizer.decodeSampledBitmapFromFile(picturePath,640,360));




        textView_adapter.setText(signleRow);


        return  CustomView;
    }

}
