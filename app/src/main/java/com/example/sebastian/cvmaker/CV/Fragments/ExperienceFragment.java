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

import com.example.sebastian.cvmaker.CV.Fragments.Adapter.ExperienceAdapter;
import com.example.sebastian.cvmaker.CV.Fragments.Models.ExperienceModel;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;


public class ExperienceFragment extends Fragment {
    public static final String source = "ExpF";
    private static boolean context_Flag = false;
    private EditText editText_Experience;
    private Button button_Experience;
    private ListView listView_Experience;
    private View VIEW;
    private ArrayList<String> listwithStuff;
    private ArrayAdapter<ExperienceModel> Adpater;
    private boolean flag = true;
    private ArrayList<ExperienceModel> experienceModelArrayList;
    private int postuons;

    public ExperienceFragment() {
    }

    public static ExperienceFragment newInstans(ArrayList<ExperienceModel> experienceModel) {

        ExperienceFragment experienceFragment = new ExperienceFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(source, experienceModel);
        experienceFragment.setArguments(args);

        context_Flag = true;


        return experienceFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        VIEW = inflater.inflate(R.layout.fragment_experience, container, false);
        experienceModelArrayList = new ArrayList<>();
        if (context_Flag) {
            experienceModelArrayList = getArguments().getParcelableArrayList(source);


            ;

        }

        if (flag)
            Initialze();
        Adpater.notifyDataSetChanged();

        button_Experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                experienceModelArrayList.add(new ExperienceModel(editText_Experience.getText().toString()));

                Adpater.notifyDataSetChanged();
                if (flag)
                    Toast.makeText(getActivity(), "Kliknij na element aby dodać wiecej informacji. Przytrzymaj aby usunać", Toast.LENGTH_SHORT).show();
                flag = false;
                editText_Experience.setText("");


            }
        });

        listView_Experience.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                bulidBilder(context_Flag, position);


            }

        });
        listView_Experience.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

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

    private void bulidBilder(boolean context_flag, final int position) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Dodatkowe Informacje");

        final EditText Input = new EditText(getContext());
        final EditText input_JobTitle = new EditText(getContext());
        final EditText input_startDate = new EditText(getContext());
        final EditText input_FinishDate = new EditText(getContext());
        final EditText input_title = new EditText(getContext());
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        Input.setInputType(InputType.TYPE_CLASS_TEXT);
        input_JobTitle.setInputType(InputType.TYPE_CLASS_TEXT);
        input_FinishDate.setInputType(InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_DATE);
        input_startDate.setInputType(InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_DATE);
        Input.setHint("Podaj firme");

        input_JobTitle.setHint("Podaj Stanowisko");
        input_FinishDate.setHint("Data ukonczenia");
        input_startDate.setHint("Data rozpoczecia");
        input_title.setHint("Zakres Obowizkow");
        input_title.setSingleLine(false);

        input_JobTitle.setSingleLine();
        input_title.setSingleLine();

        layout.addView(Input);
        layout.addView(input_title);
        layout.addView(input_JobTitle);
        layout.addView(input_startDate);
        layout.addView(input_FinishDate);

        Input.setText(experienceModelArrayList.get(position).getJob_name());


        builder.setView(layout);

        if (context_flag) {
            Input.setFocusable(false);

            input_JobTitle.setFocusable(false);
            input_FinishDate.setFocusable(false);
            input_startDate.setFocusable(false);
            input_title.setFocusable(false);

            input_JobTitle.setText(experienceModelArrayList.get(position).getExpJobTitle());
            input_title.setText(experienceModelArrayList.get(position).getExpDuties());
            input_startDate.setText(experienceModelArrayList.get(position).getExpStartDate());
            input_FinishDate.setText(experienceModelArrayList.get(position).getExpFinishDate());


        }


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (!context_Flag) {
                    experienceModelArrayList.remove(position);
                    experienceModelArrayList.add(new ExperienceModel(Input.getText().toString()
                            , input_title.getText().toString(),
                            input_JobTitle.getText().toString(),
                            input_startDate.getText().toString(),
                            input_FinishDate.getText().toString()));

                    Adpater.notifyDataSetChanged();
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

    private void Initialze() {

        editText_Experience = (EditText) VIEW.findViewById(R.id.editText_Experience);
        button_Experience = (Button) VIEW.findViewById(R.id.button_Experience);
        listView_Experience = (ListView) VIEW.findViewById(R.id.listView_Experience);
        LinearLayout to_Hide = (LinearLayout) VIEW.findViewById(R.id.LinearLayout_to_hideFexp);
        if (context_Flag) {
            to_Hide.setVisibility(View.GONE);
            editText_Experience.setVisibility(View.GONE);
            button_Experience.setVisibility(View.GONE);
        }


        listwithStuff = new ArrayList<>();


        Adpater = new ExperienceAdapter(getContext(), 1, experienceModelArrayList);


        listView_Experience.setAdapter(Adpater);
        Adpater.notifyDataSetChanged();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context_Flag)
            return;
        NavigationDr callingActivity = (NavigationDr) getActivity();

        callingActivity.onUserSelectValue(experienceModelArrayList, source);
    }
}
