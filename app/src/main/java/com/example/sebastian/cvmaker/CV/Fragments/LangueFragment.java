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

import com.example.sebastian.cvmaker.CV.Fragments.Adapter.LangueAdapter;
import com.example.sebastian.cvmaker.CV.Fragments.Models.LangueModel;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LangueFragment extends Fragment {
    public final static String source = "LF";
    private static boolean context_Flag = false;
    ListView langue_listview;
    Button langue_button;
    ArrayAdapter<LangueModel> custom_Adapter_langue;
    View fragment_View;
    ArrayList<LangueModel> langueModels;


    public LangueFragment() {
        // Required empty public constructor
    }

    public static LangueFragment newInstans(ArrayList<LangueModel> langueModel) {

        LangueFragment langueFragment = new LangueFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(source, langueModel);
        langueFragment.setArguments(args);

        context_Flag = true;


        return langueFragment;
    }

    @Override
    public void onDetach() {

        super.onDetach();
        if (context_Flag)
            return;

        NavigationDr callingActivity = (NavigationDr) getActivity();

        langueModels.remove(0);
        callingActivity.onUserSelectValue(langueModels, source);


        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        langueModels = new ArrayList<>();
        fragment_View = inflater.inflate(R.layout.fragment_langue, container, false);


        langue_listview = (ListView) fragment_View.findViewById(R.id.listView_LangueFramgent);
        if (!context_Flag)
            langueModels.add(new LangueModel("DODAJ", "A1"));

        if (context_Flag) {
            langueModels = getArguments().getParcelableArrayList(source);
        }


        custom_Adapter_langue = new LangueAdapter(getContext(), 1, langueModels);

        langue_listview.setAdapter(custom_Adapter_langue);

        langue_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (langueModels.get(position).getLangue() == "DODAJ") {

                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("Podaj jezyk który zansz");
                    alert.setMessage("zaznacz stopień zajmości :");

                    // Set an EditText view to get user input
                    final EditText input = new EditText(getContext());
                    final Spinner spinner = new Spinner(getContext());
                    LinearLayout layout = new LinearLayout(getContext());
                    layout.setOrientation(LinearLayout.HORIZONTAL);

                    ArrayAdapter<CharSequence> spinner_Adapter = ArrayAdapter.createFromResource(getContext(), R.array.langue_type, android.R.layout.simple_spinner_item);
                    spinner_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(spinner_Adapter);
                    input.setHint("Podaj jezyk            ");

                    layout.addView(input);
                    layout.addView(spinner);

                    alert.setView(layout);


                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            String value = input.getText().toString();
                            String spinnerValue = spinner.getSelectedItem().toString();
                            langueModels.add(new LangueModel(value, spinnerValue));
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


                    custom_Adapter_langue.notifyDataSetChanged();


                }
            }
        });

        custom_Adapter_langue.notifyDataSetChanged();
        return fragment_View;

    }
}
