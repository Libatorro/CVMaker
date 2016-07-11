package com.example.sebastian.cvmaker.CV.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.sebastian.cvmaker.CV.Fragments.Adapter.TraningAdapert;
import com.example.sebastian.cvmaker.CV.Fragments.Models.TraningModel;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;


public class TrainingFragment extends Fragment {

    public final static String source = "TRF";
    private static final int STATIC_INTEGER_VALUE = 4;
    private static boolean context_Flag = false;
    ListView traning_listview;
    ArrayAdapter<TraningModel> custom_Adapter_traning;
    ArrayList<TraningModel> list_with_data;
    ArrayList<TraningModel> modelArrayList;
    View fragment_View;
    ///
    String input_Cursname;
    String input_Date;
    String input_ExtraDealis;
    private String picturePath;
    private String adpaterText;

    public static TrainingFragment newInstans(ArrayList<TraningModel> traningModel) {
        TrainingFragment trainingFragment = new TrainingFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(source, traningModel);
        trainingFragment.setArguments(args);

        context_Flag = true;


        return trainingFragment;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context_Flag)
            return;

        NavigationDr callingActivity = (NavigationDr) getActivity();// // TODO: POWINOO BYC HASHMAP <kLUCZ, WAROSC> ALE NIE MAM CZASU ZMIENIAC WSZYSKIEGO ZROBIE TO ŁOPATTCZNIE
        if (!modelArrayList.isEmpty())
            callingActivity.onUserSelectValue(modelArrayList, source);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment_View = inflater.inflate(R.layout.fragment_training, container, false);
        list_with_data = new ArrayList<>();


        if (context_Flag) {
            list_with_data = getArguments().getParcelableArrayList(source);


        }


        traning_listview = (ListView) fragment_View.findViewById(R.id.listView_TraningFragment);

        if (!context_Flag)
            list_with_data.add(new TraningModel("Dodaj", " "));
        modelArrayList = new ArrayList<>();

        custom_Adapter_traning = new TraningAdapert(getContext(), 5, list_with_data);

        traning_listview.setAdapter(custom_Adapter_traning);


        traning_listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        picturePath = "";
                        if (list_with_data.get(position).getName_Traning() == "Dodaj") {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Informacje na Temat");


                            final EditText input_City = new EditText(getContext());
                            final EditText input_startDate = new EditText(getContext());
                            final EditText input_FinishDate = new EditText(getContext());

                            LinearLayout layout = new LinearLayout(getContext());
                            layout.setOrientation(LinearLayout.VERTICAL);


                            input_City.setInputType(InputType.TYPE_CLASS_TEXT);
                            input_FinishDate.setInputType(InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_DATE);

                            input_City.setHint("Nazwa Kursu/Szkolenia");
                            input_FinishDate.setHint("Data");
                            input_startDate.setHint("Dodatkowe Informacje");


                            layout.addView(input_City);
                            layout.addView(input_FinishDate);
                            layout.addView(input_startDate);


                            builder.setView(layout);

                            builder.setNeutralButton("Załącz certyfikat", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {


                                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                    startActivityForResult(i, STATIC_INTEGER_VALUE);
                                    adpaterText = input_City.getText().toString();
                                    input_Cursname = input_City.getText().toString();
                                    input_Date = input_FinishDate.getText().toString();
                                    input_ExtraDealis = input_startDate.getText().toString();


                                }
                            });


                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {


                                    list_with_data.add(new TraningModel(input_City.getText().toString(), picturePath));
                                    custom_Adapter_traning.notifyDataSetChanged();


                                    modelArrayList.add(new TraningModel(input_City.getText().toString(), input_FinishDate.getText().toString(), input_startDate.getText().toString(), picturePath));


                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                            builder.show();


                        }

                    }
                }
        );


        return fragment_View;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == STATIC_INTEGER_VALUE && resultCode == Activity.RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            list_with_data.add(new TraningModel(adpaterText, picturePath));
            modelArrayList.add(new TraningModel(input_Cursname, input_Date, input_ExtraDealis, picturePath));

            custom_Adapter_traning.notifyDataSetChanged();


        }
    }
}
