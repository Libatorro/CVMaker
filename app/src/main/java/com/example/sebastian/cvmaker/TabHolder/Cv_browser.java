package com.example.sebastian.cvmaker.TabHolder;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sebastian.cvmaker.CV.Fragments.EducationFragment;
import com.example.sebastian.cvmaker.CV.Fragments.ExperienceFragment;
import com.example.sebastian.cvmaker.CV.Fragments.InterestsFragment;
import com.example.sebastian.cvmaker.CV.Fragments.LangueFragment;
import com.example.sebastian.cvmaker.CV.Fragments.PersonalDetalis;
import com.example.sebastian.cvmaker.CV.Fragments.SkillsFragment;
import com.example.sebastian.cvmaker.CV.Fragments.TrainingFragment;
import com.example.sebastian.cvmaker.CV.NavigatioDrawer.MainHolder;
import com.example.sebastian.cvmaker.MainActivity.MainActivity;
import com.example.sebastian.cvmaker.R;

import java.io.File;

public class Cv_browser extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    MainHolder andrzej= MainHolder.Obcjet_Reader("firstone");
 public  static String CvFileName="";
    private ViewPager mViewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_browser);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        ChooseCvBuldier();








        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Przesuń ekran w lewo lub w prawo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





    }



    private void zmien_toolbar(int k) {
switch (k) {
    case 0:
        getSupportActionBar().setTitle("ddddddddddddddddd");
        break;
    case 1:
        getSupportActionBar().setTitle(R.string.Edukacja);
        break;
    case 2:
        getSupportActionBar().setTitle(R.string.Doświadczenie);
        break;
    case 3:
        getSupportActionBar().setTitle(R.string.Szkolenia);
        break;
    case 4:
        getSupportActionBar().setTitle(R.string.Certyfikaty);
        break;
    case 5:
        getSupportActionBar().setTitle(R.string.Jezyki);
        break;
    case 6:
        getSupportActionBar().setTitle(R.string.Zainteresowania);
        break;
}
    }


    private void ChooseCvBuldier() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wybierz CV");
        String[] Cv_List= new File(MainActivity.CV_PATH).list();
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);



        final Button [] buttons = new Button[Cv_List.length];

        for (int i = 0; i < Cv_List.length; i++) {

            buttons[i]=new Button(this);
            buttons[i].setText(Cv_List[i]);
            layout.addView(buttons[i]);

        }
        builder.setView(layout);

         final AlertDialog alert= builder.create();
        for (int i = 0; i < Cv_List.length; i++) {

            final int finalI = i;
            buttons[i].setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            CvFileName= String.valueOf(buttons[finalI].getText());
                            Toast.makeText(Cv_browser.this, CvFileName+"", Toast.LENGTH_SHORT).show();


                            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

                            // Set up the ViewPager with the sections adapter.
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            mViewPager.setAdapter(mSectionsPagerAdapter);


alert.dismiss();
                        }
                    }
            );

        }



        alert.show();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cv_browser, menu);
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


            ChooseCvBuldier();





            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:  zmien_toolbar(position);      getSupportActionBar().setTitle(R.string.Daneobobowe); return  PersonalDetalis.newInstans(MainHolder.Obcjet_Reader(CvFileName).getPersonalDetalis());
                case 1 :zmien_toolbar(position);  return   EducationFragment.newInstans(MainHolder.Obcjet_Reader(CvFileName).getEduciatonModel());
                case 2: zmien_toolbar(position);  return  ExperienceFragment.newInstans(MainHolder.Obcjet_Reader(CvFileName).getExperienceModel());
                case 3: zmien_toolbar(position);  return SkillsFragment.newInstans(MainHolder.Obcjet_Reader(CvFileName).getSkillsModel());
                case 4: zmien_toolbar(position);  return  TrainingFragment.newInstans(MainHolder.Obcjet_Reader(CvFileName).getTraningModel());
                case 5: zmien_toolbar(position);  return  LangueFragment.newInstans(MainHolder.Obcjet_Reader(CvFileName).getLangueModel());
                case 6:  zmien_toolbar(position);  return  InterestsFragment.newInstans(MainHolder.Obcjet_Reader(CvFileName).getInterestsModel());
            }
            return null; //if you use default, you would not need to return null
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    getSupportActionBar().setTitle("ddddddddddddddddd");
                    break;
                case 1:
                    getSupportActionBar().setTitle(R.string.Edukacja);
                    break;
                case 2:
                    getSupportActionBar().setTitle(R.string.Doświadczenie);
                    break;
                case 3:
                    getSupportActionBar().setTitle(R.string.Szkolenia);
                    break;
                case 4:
                    getSupportActionBar().setTitle(R.string.Certyfikaty);
                    break;
                case 5:
                    getSupportActionBar().setTitle(R.string.Jezyki);
                    break;
                case 6:
                    getSupportActionBar().setTitle(R.string.Zainteresowania);
                    break;
            }
            return null;
        }
    }
}
