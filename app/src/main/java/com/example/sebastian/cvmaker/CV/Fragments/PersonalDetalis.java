package com.example.sebastian.cvmaker.CV.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.sebastian.cvmaker.CV.Fragments.Models.PersonalModel;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;


public class PersonalDetalis extends Fragment {

    public final static String source = "PD";
    private static final int STATIC_INTEGER_VALUE = 4;
    public static boolean context_Flag = false;
    public static String PUBLIC_STATIC_STRING_IDENTIFIER = "PD";
    View view;
    Button button_calendar, button_maps;
    ImageView cvPhoto;
    EditText pd_Name, pd_SurName, pd_birthDate, pd_bornPlace, pd_email;
    ArrayList<PersonalModel> personalModelArrayList;
    private Uri imageUri;
    private ArrayList<String> contentDate;
    private String picturePath = "";


    public PersonalDetalis() {
        // Required empty public constructor
    }

    public static PersonalDetalis newInstans(ArrayList<String> K) {
        PersonalDetalis personalDetalis = new PersonalDetalis();


        Bundle args = new Bundle();
        args.putStringArrayList("someInt", K);
        personalDetalis.setArguments(args);
        context_Flag = true;

        return personalDetalis;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal_detalis, container, false);
        init(view);

        if (context_Flag) {

            ArrayList<String> set = getArguments().getStringArrayList("someInt");

            pd_Name.setFocusable(false);
            pd_SurName.setFocusable(false);
            pd_email.setFocusable(false);
            pd_birthDate.setFocusable(false);
            pd_bornPlace.setFocusable(false);

            if (!set.isEmpty()) {


                if(!set.get(0).isEmpty())
                    cvPhoto.setImageBitmap(BitmapFactory.decodeFile(set.get(0)));
                pd_Name.setText(set.get(1));
                pd_SurName.setText(set.get(2));
                pd_birthDate.setText(set.get(3));
                pd_bornPlace.setText(set.get(4));
                pd_email.setText(set.get(5));




            }
        }
//take_picure_button = (Button) view.findViewById(R.id.PD_take_picure);
//
//take_picure_button.setOnClickListener(
//        new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                File photo = new File(Environment.getExternalStorageDirectory().toString() + "/CVMaker/CV/CVPhotos",  new Random().nextInt(1000)+"Pic.jpg");
//                intent.putExtra(MediaStore.EXTRA_OUTPUT,
//                        Uri.fromFile(photo));
//                imageUri = Uri.fromFile(photo);
//                startActivityForResult(intent, TAKE_PICTURE);
//
//
//            }
//        }
//);


        return view;
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

            cvPhoto.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        if(context_Flag)
            return;


        NavigationDr callingActivity = (NavigationDr) getActivity();// // TODO: POWINOO BYC HASHMAP <kLUCZ, WAROSC> ALE NIE MAM CZASU ZMIENIAC WSZYSKIEGO ZROBIE TO ŁOPATTCZNIE

        contentDate.add(picturePath);
        contentDate.add(pd_Name.getText().toString());
        contentDate.add(pd_SurName.getText().toString());
        contentDate.add(pd_birthDate.getText().toString());
        contentDate.add(pd_bornPlace.getText().toString());
        contentDate.add(pd_email.getText().toString());


        callingActivity.onUserSelectValue(contentDate, source);


    }

    public void init(final View VIEW) {
        contentDate = new ArrayList<>();
        personalModelArrayList = new ArrayList<>();
        pd_birthDate = (EditText) VIEW.findViewById(R.id.editTextPD_bithtDate);

        pd_bornPlace = (EditText) VIEW.findViewById(R.id.editTextPD_BornPlace);

        pd_Name = (EditText) VIEW.findViewById(R.id.editTextPd_Name);

        pd_SurName = (EditText) VIEW.findViewById(R.id.editTextPd_Surname);

        pd_email = (EditText) VIEW.findViewById(R.id.editTextPd_Email);
        button_calendar = (Button) VIEW.findViewById(R.id.button_calendar);
        button_maps = (Button) VIEW.findViewById(R.id.button_maps);

        cvPhoto = (ImageView) VIEW.findViewById(R.id.imageView_CVPhoto);
        cvPhoto.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, STATIC_INTEGER_VALUE);

                        return false;
                    }
                }
        );


    }


}
