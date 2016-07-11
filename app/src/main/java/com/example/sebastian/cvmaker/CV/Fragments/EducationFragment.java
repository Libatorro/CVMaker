package com.example.sebastian.cvmaker.CV.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sebastian.cvmaker.CV.Fragments.Adapter.EducationAdapter;
import com.example.sebastian.cvmaker.CV.Fragments.Models.EduciatonModel;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {
    public static final String source = "EF";
    public static boolean context_Flag = false;
    boolean flag = true;
    private EditText editText_Education;
    private Button button_Educiaton;
    private ListView listView_Eduaction;
    private View VIEW;
    private ArrayList<String> listwithStuff;
    private ArrayAdapter<EduciatonModel> Adpater;
    private ArrayList<EduciatonModel> educiatonModelArrayList;
    private int positionn;
    private boolean falg = true;

    public EducationFragment() {

    }


    public static EducationFragment newInstans(ArrayList<EduciatonModel> educiatonModels) {
        for (int i = 0; i < 100; i++) {

            System.out.println("z jakiej paki to sie wkonuje");
        }
        EducationFragment educationFragment = new EducationFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("lstContact", educiatonModels);
        educationFragment.setArguments(args);

        context_Flag = true;


        return educationFragment;
    }


    @Override
    public void onDetach() {
        super.onDetach();

        if (context_Flag)
            return;

        NavigationDr callingActivity = (NavigationDr) getActivity();


        callingActivity.onUserSelectValue(educiatonModelArrayList, source);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        VIEW = inflater.inflate(R.layout.fragment_education, container, false);
        educiatonModelArrayList = new ArrayList<>();

        if (context_Flag) {

            educiatonModelArrayList = getArguments().getParcelableArrayList("lstContact");


        }

        if (flag)
            Initialze();

        button_Educiaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                educiatonModelArrayList.add(new EduciatonModel(editText_Education.getText().toString()));
                Adpater.notifyDataSetChanged();
                if (flag)
                    Toast.makeText(getActivity(), "Kliknij na element aby dodać wiecej informacji. Przytrzymaj aby usunać", Toast.LENGTH_SHORT).show();
                flag = false;
                editText_Education.setText("");
            }
        });


        listView_Eduaction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {

                positionn = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Dodatkowe Informacje");


                    final EditText input_JobTitle = new EditText(getContext());
                    final EditText input_startDate = new EditText(getContext());
                    final EditText input_FinishDate = new EditText(getContext());
                    final EditText input_title = new EditText(getContext());
                    LinearLayout layout = new LinearLayout(getContext());
                    layout.setOrientation(LinearLayout.VERTICAL);

                    input_JobTitle.setSingleLine();
                    input_title.setSingleLine();

                    input_JobTitle.setInputType(InputType.TYPE_CLASS_TEXT);
                    input_FinishDate.setInputType(InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_DATE);
                    input_startDate.setInputType(InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_DATE);
                    input_JobTitle.setHint("Podaj Miasto");
                    input_FinishDate.setHint("Data ukonczenia");
                    input_startDate.setHint("Data rozpoczecia");
                    input_title.setHint("Uzyskany tytuł");

                    layout.addView(input_title);
                    layout.addView(input_JobTitle);
                    layout.addView(input_startDate);
                    layout.addView(input_FinishDate);


                if (context_Flag) {

                    input_JobTitle.setFocusable(false);
                    input_JobTitle.setText(educiatonModelArrayList.get(position).getDetalis_city());
                    input_title.setText(educiatonModelArrayList.get(position).getDetalis_title());
                    input_title.setFocusable(false);
                    input_startDate.setText(educiatonModelArrayList.get(position).getDetalis_startDate());
                    input_startDate.setFocusable(false);
                    input_FinishDate.setFocusable(false);
                    input_FinishDate.setText(educiatonModelArrayList.get(position).getDetalis_finishDate());
                }

                    builder.setView(layout);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!context_Flag) {

                            String helpe = educiatonModelArrayList.get(position).getSchoolName();
                            educiatonModelArrayList.remove(position);
                            educiatonModelArrayList.add(new EduciatonModel(
                                    helpe,
                                    input_title.getText().toString(),
                                    input_JobTitle.getText().toString(),
                                    input_startDate.getText().toString(),
                                    input_FinishDate.getText().toString()
                            ));
                        }

                    }
                });
                if (!context_Flag)
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                builder.show();


            }
        });
        listView_Eduaction.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           int index, long arg3) {

                Toast.makeText(getActivity(), listwithStuff.get(index) + " Usunieto", Toast.LENGTH_LONG).show();
                listwithStuff.remove(index);
                Adpater.notifyDataSetChanged();
                return false;

            }
        });


        return VIEW;
    }

    private void Initialze() {
        // Inflate the layout for this fragment
        listwithStuff = new ArrayList<>();


        editText_Education = (EditText) VIEW.findViewById(R.id.editText_Education);
        button_Educiaton = (Button) VIEW.findViewById(R.id.button_Edukaction);
        listView_Eduaction = (ListView) VIEW.findViewById(R.id.listView_Education);
        LinearLayout to_Hide = (LinearLayout) VIEW.findViewById(R.id.LinearLayout_toHideFedu);
        if (context_Flag) {
            to_Hide.setVisibility(View.GONE);
            // editText_Education.setVisibility(View.GONE);
            // button_Educiaton.setVisibility(View.GONE);
        }
        Adpater = new EducationAdapter(getContext(), 1, educiatonModelArrayList);
        listView_Eduaction.setAdapter(Adpater);


        Adpater.notifyDataSetChanged();
    }

}
