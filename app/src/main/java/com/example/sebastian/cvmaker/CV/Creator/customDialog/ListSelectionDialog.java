package com.example.sebastian.cvmaker.CV.Creator.customDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2016-07-01.
 */
public class ListSelectionDialog extends DialogFragment {
ArrayList<String> categorySeleceted = new ArrayList<>();
public final static String source="LSD";
  

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String [] items = getResources().getStringArray(R.array.cv_selection);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Wybierz kategorie do CV").setMultiChoiceItems(R.array.cv_selection, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
if(isChecked)
{
    categorySeleceted.add(items[which]);
}
else if(categorySeleceted.contains(items[which]))
{
    categorySeleceted.remove(items[which]);
}


            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NavigationDr callingActivity = (NavigationDr) getActivity();// // TODO: 2016-07-01 wazne rzeczy
                callingActivity.onUserSelectValue(categorySeleceted,source);

            
            }
        });


        return builder.create();
    }

}
