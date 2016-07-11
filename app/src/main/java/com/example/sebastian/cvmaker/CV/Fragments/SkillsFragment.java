package com.example.sebastian.cvmaker.CV.Fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.sebastian.cvmaker.CV.Fragments.Adapter.SkillsAdpater;
import com.example.sebastian.cvmaker.CV.Fragments.Models.SkillsModel;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsFragment extends Fragment {
    public static final String source = "SF";
    private static boolean context_Flag = false;
    ListView listView_Skills;
    View View_Skill;
    ArrayAdapter<SkillsModel> skillmodel_Adapter;
    ArrayList<SkillsModel> skillmodel_List;
    private int textView_couter = 0;

    public SkillsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstans(ArrayList<SkillsModel> firstone) {


        SkillsFragment experienceFragment = new SkillsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(source, firstone);
        experienceFragment.setArguments(args);

        context_Flag = true;


        return experienceFragment;


    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context_Flag)
            return;
        NavigationDr callingActivity = (NavigationDr) getActivity();

        skillmodel_List.remove(0);
        if (!skillmodel_List.isEmpty())
            callingActivity.onUserSelectValue(skillmodel_List, source);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View_Skill = inflater.inflate(R.layout.fragment_skills, container, false);
        skillmodel_List = new ArrayList<>();
        if (context_Flag) {
            skillmodel_List = getArguments().getParcelableArrayList(source);
            System.out.println(skillmodel_List.toString());
        }

        Initialize(View_Skill);


        return View_Skill;
    }

    private void Initialize(View view_skill) {

        listView_Skills = (ListView) view_skill.findViewById(R.id.listView_skills);
        if (!context_Flag)
            skillmodel_List.add(new SkillsModel("DODAJ", new ArrayList<String>()));

        skillmodel_Adapter = new SkillsAdpater(getContext(), 1, skillmodel_List);


        listView_Skills.setAdapter(skillmodel_Adapter);

        listView_Skills = (ListView) view_skill.findViewById(R.id.listView_skills);
        skillmodel_Adapter.notifyDataSetChanged();

        listView_Skills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (skillmodel_List.get(position).getSkill_titile() == "DODAJ") {

                    final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Podaj jezyk który zansz");
                    alert.setMessage("zaznacz stopień zajmości :");

                    // Set an EditText view to get user input
                    textView_couter = 0;
                    final EditText[] inputA = new EditText[4];
                    final EditText input = new EditText(getContext());
                    final Spinner spinner = new Spinner(getContext());
                    final LinearLayout layout = new LinearLayout(getContext());
                    layout.setOrientation(LinearLayout.VERTICAL);
                    Button adding_button = new Button(getContext());
                    adding_button.setText("-+-");
                    layout.addView(adding_button);


                    adding_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (textView_couter > 3)
                                return;

                            inputA[textView_couter] = new EditText(getContext());
                            inputA[textView_couter].setHint("dodaj dodatkowe informacje");
                            inputA[textView_couter].setSingleLine();

                            layout.addView(inputA[textView_couter]);
                            alert.setView(layout);
                            textView_couter++;

                        }
                    });


                    input.setHint("Podaj kategorie");

                    layout.addView(input);
                    layout.addView(spinner);

                    alert.setView(layout);


                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                            ArrayList<String> output = new ArrayList<String>();
                            for (int i = 0; i < textView_couter; i++) {

                                output.add(i, inputA[i].getText().toString());
                            }

                            skillmodel_List.add(new SkillsModel(input.getText().toString(), output));
                            skillmodel_Adapter.notifyDataSetChanged();

                        }
                    });

                    alert.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    return;
                                }
                            });


                    alert.show();


                    skillmodel_Adapter.notifyDataSetChanged();


                }
            }
        });


    }


}
