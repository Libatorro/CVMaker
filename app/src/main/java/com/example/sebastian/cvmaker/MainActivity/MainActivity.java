package com.example.sebastian.cvmaker.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sebastian.cvmaker.CV.Fragments.Models.EduciatonModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.ExperienceModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.LangueModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.PersonalModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.SkillsModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.TraningModel;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.MainHolder;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.NavigationDr;
import com.example.sebastian.cvmaker.R;
import com.example.sebastian.cvmaker.TabHolder.Cv_browser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String MAINPATH = Environment.getExternalStorageDirectory().toString() + "/CVMaker/CV/";
    public static final String CV_PATH = Environment.getExternalStorageDirectory().toString() + "/CVMaker/CV/CVDate/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDirectory();


        Make_Exemple();


    }

    private void Make_Exemple() {
        ArrayList<String> arrayList = new ArrayList<>();
        MainHolder example = new MainHolder();
        PersonalModel pd = new PersonalModel("", "Jan", "Kowalski", "01-12-1980", "Warszawa", "JanKowalkis@gmial.com");
        EduciatonModel educiatonModel = new EduciatonModel("Uniwersystet Warszawaski", "Licencjat Ekonomi", "Wraszawa", "2000", "2004");
        EduciatonModel educiatonModel1 = new EduciatonModel("Politechnia Wrocławska", "Mrg.Inż Budownictwa", "Wrocław", "2005", "2010");
        ExperienceModel m4 = new ExperienceModel("Exbud sp z o.o. ", "inżynier budowy ", "inżynier budowy", "2015", "2016");
        ExperienceModel m3 = new ExperienceModel("Mostostal Warszawa S.A. ", "nadzór nad poprawnością wykonania izolacji\n" +
                "przeciwwilgociowych pionowych ", "Asystent Kierownika", "2014", "2015");
        ExperienceModel m2 = new ExperienceModel("2INVEST Group", "Zakres moich obowiązków obejmował nadzór nad poprawnością wykonania ścian działowych\n" +
                "w lokalach mieszkalnych na inwestycjach ", "Asystent Kierownika", "2013", "2014");
        ExperienceModel m1 = new ExperienceModel(" redNet Dom Sp z o.o", "Tworzenie dokumentacji,nadzór budowlany, dowodzenie brygadą ", "  Koordynator robót wykończeniowych ", "2012", "2013");

        arrayList.add(" Microsoft Office ");
        arrayList.add("Windows");
        arrayList.add("Linux");
        SkillsModel s1 = new SkillsModel(" obsługa komputera", (arrayList));
        arrayList = new ArrayList<>();
        arrayList.add(" AutoCad");
        arrayList.add("Briscad");
        arrayList.add("NORMA");


        SkillsModel s2 = new SkillsModel("dobra znajomość pakietów   ", arrayList);

        arrayList = new ArrayList<>();
        arrayList.add("Kat. A");
        arrayList.add("Kat. B");
        arrayList.add("Kat. C");
        arrayList.add("Kat. CDE");

        SkillsModel s3 = new SkillsModel("PrawoJazdy", arrayList);
        LangueModel l1 = new LangueModel("Angielski", "B1");
        LangueModel l2 = new LangueModel("Niemiecki", "A1");
        TraningModel t1 = new TraningModel("Certificate", "2009", "The summer English Language Program", "");
        TraningModel t2 = new TraningModel("MS Project ", "2010", " podstawy tworzenia i realizacji projektu ", "");
        TraningModel t3 = new TraningModel("Elementarny Kurs Pierwszej Pomocy  ", "2010", "PCK ", "");

        List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("", "Jan", "Kowalski", "01-12-1980", "Warszawa", "JanKowalkis@gmial.com"));


        example.setPersonalDetalis((ArrayList<String>) list);
        ArrayList<EduciatonModel> arrayLista = new ArrayList<>();
        arrayLista.add(educiatonModel);
        arrayLista.add(educiatonModel1);
        example.setEduciatonModel(arrayLista);
        ArrayList<ExperienceModel> exp = new ArrayList<>();
        exp.add(m1);
        exp.add(m2);
        exp.add(m3);
        exp.add(m4);

        example.setExperienceModel(exp);

        ArrayList<SkillsModel> ak = new ArrayList<>();
        ak.add(s1);
        ak.add(s2);
        ak.add(s3);
        example.setSkillsModel(ak);
        ArrayList<LangueModel> al = new ArrayList<>();
        al.add(l1);
        al.add(l2);
        example.setLangueModel(al);
        ArrayList<TraningModel> tm = new ArrayList<>();
        tm.add(t1);
        tm.add(t2);
        tm.add(t3);
        example.setTraningModel(tm);
        arrayList = new ArrayList<>();
        arrayList.add("sport, motoryzacja, architektura.");
        example.setInterestsModel(arrayList);


        MainHolder.Object_Writer(example, "JANKOWLASKI");

        System.out.println(MainHolder.Obcjet_Reader("JANKOWLASKI").toString());


    }

    public void createCV_button(View v) {
        Intent SHOW_CV = new Intent(this, NavigationDr.class); // TODO zmianic tutaj potem na CV_SHOW_activity

        startActivity(SHOW_CV);

    }

    public void showCV_button(View v) {
        Intent SHOW_CV = new Intent(this, Cv_browser.class); // TODO zmianic tutaj potem na CV_SHOW_activity

        startActivity(SHOW_CV);

    }


    public void createDirectory() {
        {
            new File(Environment.getExternalStorageDirectory().toString() + "/CVMaker/CV/").mkdirs();
            (new File((Environment.getExternalStorageDirectory().toString() + "/CVMaker/CV/CVPhotos"))).mkdirs();
            new File((Environment.getExternalStorageDirectory().toString() + "/CVMaker/CV/CVDate")).mkdirs();


        }


    }
}
