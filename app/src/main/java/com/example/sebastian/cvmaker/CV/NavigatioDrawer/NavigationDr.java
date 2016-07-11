package com.example.sebastian.cvmaker.CV.NavigatioDrawer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sebastian.cvmaker.CV.Fragments.CheckFragment;
import com.example.sebastian.cvmaker.CV.Fragments.CheckFragmentt;
import com.example.sebastian.cvmaker.CV.Fragments.Models.EduciatonModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.ExperienceModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.LangueModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.SkillsModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.TraningModel;
import com.example.sebastian.cvmaker.CV.Fragments.SkillsFragment;
import com.example.sebastian.cvmaker.CV.Fragments.EducationFragment;
import com.example.sebastian.cvmaker.CV.Fragments.ExperienceFragment;
import com.example.sebastian.cvmaker.CV.Fragments.InterestsFragment;
import com.example.sebastian.cvmaker.CV.Fragments.LangueFragment;
import com.example.sebastian.cvmaker.CV.Fragments.PersonalDetalis;
import com.example.sebastian.cvmaker.CV.Fragments.TrainingFragment;
import com.example.sebastian.cvmaker.R;

import java.util.ArrayList;

public class NavigationDr extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    private DrawerLayout drawer;
    private SkillsFragment certyfikatfragment;
    private TrainingFragment trainingfragment;
    private InterestsFragment intrestFragment;
    private LangueFragment languefragment;
    private ExperienceFragment experienceFragment;
    private EducationFragment educationFragment;
    private PersonalDetalis personalDetalis;
    private CheckFragmentt checkFragment;

    public  static ArrayList<Boolean> booleanArrayList;
private MainHolder mainHolder;

    private void initalize() {
        certyfikatfragment = new SkillsFragment();
        trainingfragment = new TrainingFragment();
checkFragment = new CheckFragmentt();
        intrestFragment = new InterestsFragment();
        languefragment = new LangueFragment();
        experienceFragment = new ExperienceFragment();
        educationFragment = new EducationFragment();
        personalDetalis = new PersonalDetalis();
        mainHolder = new MainHolder();
        booleanArrayList = new ArrayList<>();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


 //       ListSelectionDialog Cv_catregory = new ListSelectionDialog();
/// TODO: 2016-07-06 wylaczylem na razie ten chooselist menu
    //    Cv_catregory.show(getFragmentManager(), "chooselist");
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
        navigationView.setNavigationItemSelectedListener(this);

        initalize();

    }

    public <T> void onUserSelectValue(ArrayList<T> choose, String Source) {
      //  if (Source == ListSelectionDialog.source)
           // hide_the_meun_options((ArrayList<String>) choose);

        if (Source == PersonalDetalis.source) {
            booleanArrayList.add(0,true);
            mainHolder.setPersonalDetalis((ArrayList<String>) choose);
            // todo wziac te dane i zrobic z nich jakas klase potem ja zapisac do pliku
        }
        if (Source == EducationFragment.source) {
            mainHolder.setEduciatonModel((ArrayList<EduciatonModel>) choose);
            booleanArrayList.add(1,true);

        }

        if (Source == ExperienceFragment.source){
            mainHolder.setExperienceModel((ArrayList<ExperienceModel>) choose);
            booleanArrayList.add(2,true);

        }



        if (Source == LangueFragment.source){
            mainHolder.setLangueModel((ArrayList<LangueModel>) choose);
            booleanArrayList.add(3,true);

        }
        if (Source == SkillsFragment.source){
            mainHolder.setSkillsModel((ArrayList<SkillsModel>) choose);
            booleanArrayList.add(4,true);

        }
        if (Source == TrainingFragment.source){
            mainHolder.setTraningModel((ArrayList<TraningModel>) choose);
            booleanArrayList.add(5,true);

        }
        if (Source == InterestsFragment.source) {
            mainHolder.setInterestsModel((ArrayList<String>) choose);
            booleanArrayList.add(6,true);


        }





    }

    private void hide_the_meun_options(ArrayList<String> choose) {
        final Menu menu = navigationView.getMenu();
        MenuItem nav_camara;
        for (int i = 0; i < menu.size(); i++) {
            menu.getItem(i).setVisible(false);
        }


        for (String x : choose) {
            if (x.equals("Dane Osobowe")) {

                nav_camara = menu.findItem(R.id.nav_dane_osobowe);
                nav_camara.setVisible(true);

            }
            if (x.equals("Edukacja")) {

                nav_camara = menu.findItem(R.id.nav_edukacja);
                nav_camara.setVisible(true);

            }
            if (x.equals("Doświadczenie")) {

                nav_camara = menu.findItem(R.id.nav_Doswiadczenie);
                nav_camara.setVisible(true);

            }
            if (x.equals("Jezyki")) {

                nav_camara = menu.findItem(R.id.nav_jezyki);
                nav_camara.setVisible(true);

            }
            if (x.equals("Certyfikaty")) {

                nav_camara = menu.findItem(R.id.nav_certyfikaty);
                nav_camara.setVisible(true);

            }
            if (x.equals("Szkolenia")) {

                nav_camara = menu.findItem(R.id.nav_szkolenia);
                nav_camara.setVisible(true);

            }
            if (x.equals("Zainteresowania")) {

                nav_camara = menu.findItem(R.id.nav_zainteresowania);
                nav_camara.setVisible(true);

            }

        }


        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);



        if (!drawer.isDrawerOpen(GravityCompat.START))
        {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Layout_for_fragment, checkFragment).commit();

        }




        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Layout_for_fragment, checkFragment).commit();
        }
        else {


            alert();
            //  super.onBackPressed();
        }
    }


    private void alert() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("");

        // Setting Dialog Message.
        alertDialog.setMessage("Chcesz zakończyć ?");


        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {


                if(booleanArrayList.get(0))
                MainHolder.Object_Writer(mainHolder,mainHolder.getPersonalDetalis().get(0)+mainHolder.getPersonalDetalis().get(1));



                finish();

            }

        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NIE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event


                dialog.cancel();
            }
        });


        // Showing Alert Message
        alertDialog.show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        FragmentManager manager = getSupportFragmentManager();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dane_osobowe) {


            manager.beginTransaction().replace(R.id.Layout_for_fragment, personalDetalis).commit();

        } else if (id == R.id.nav_edukacja) {


            manager.beginTransaction().replace(R.id.Layout_for_fragment, educationFragment).commit();

        } else if (id == R.id.nav_Doswiadczenie) {

            manager.beginTransaction().replace(R.id.Layout_for_fragment, experienceFragment).commit();

        } else if (id == R.id.nav_jezyki) {

            manager.beginTransaction().replace(R.id.Layout_for_fragment, languefragment).commit();


        } else if (id == R.id.nav_certyfikaty) {

            manager.beginTransaction().replace(R.id.Layout_for_fragment, certyfikatfragment).commit();

        } else if (id == R.id.nav_szkolenia) {


            manager.beginTransaction().replace(R.id.Layout_for_fragment, trainingfragment).commit();

        } else if (id == R.id.nav_zainteresowania) {

            manager.beginTransaction().replace(R.id.Layout_for_fragment, intrestFragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
