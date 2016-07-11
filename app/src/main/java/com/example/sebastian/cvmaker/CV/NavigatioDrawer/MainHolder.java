package com.example.sebastian.cvmaker.CV.NavigatioDrawer;

import com.example.sebastian.cvmaker.CV.Fragments.InterestsFragment;
import com.example.sebastian.cvmaker.CV.Fragments.Models.EduciatonModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.ExperienceModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.LangueModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.SkillsModel;
import com.example.sebastian.cvmaker.CV.Fragments.Models.TraningModel;
import com.example.sebastian.cvmaker.CV.Fragments.PersonalDetalis;
import com.example.sebastian.cvmaker.MainActivity.MainActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sebastian on 2016-07-07.
 */
public class MainHolder implements Serializable {
    private static final long serialVersionUID = 3812017177088226528L;
    private ArrayList<String> personalDetalis;
    private ArrayList<EduciatonModel> educiatonModel;
    private ArrayList<ExperienceModel> experienceModel;
    private ArrayList<SkillsModel> skillsModel;
    private ArrayList<LangueModel> langueModel;
    private ArrayList<TraningModel> traningModel;

    private ArrayList<String> interestsModel;



    public MainHolder() {
        personalDetalis= new ArrayList<>();
        educiatonModel= new ArrayList<>();
        experienceModel= new ArrayList<>();
        skillsModel= new ArrayList<>();
        langueModel= new ArrayList<>();
        traningModel= new ArrayList<>();
        interestsModel= new ArrayList<>();
    }

    @Override
    public String   toString() {

        toSString(personalDetalis);
        toSString(educiatonModel);
        toSString(experienceModel);
        toSString(skillsModel);
        toSString(langueModel);
        toSString(traningModel);
        toSString(interestsModel);
        return "";
    }

    public ArrayList<String> getPersonalDetalis() {
        return personalDetalis;
    }

    public void setPersonalDetalis(ArrayList<String> personalDetalis) {
        this.personalDetalis = personalDetalis;
    }

    public ArrayList<EduciatonModel> getEduciatonModel() {
        return educiatonModel;
    }

    public void setEduciatonModel(ArrayList<EduciatonModel> educiatonModel) {
        this.educiatonModel = educiatonModel;
    }

    public ArrayList<ExperienceModel> getExperienceModel() {
        return experienceModel;
    }

    public void setExperienceModel(ArrayList<ExperienceModel> experienceModel) {
        this.experienceModel = experienceModel;
    }

    public ArrayList<SkillsModel> getSkillsModel() {
        return skillsModel;
    }

    public void setSkillsModel(ArrayList<SkillsModel> skillsModel) {
        this.skillsModel = skillsModel;
    }

    public ArrayList<LangueModel> getLangueModel() {
        return langueModel;
    }

    public void setLangueModel(ArrayList<LangueModel> langueModel) {
        this.langueModel = langueModel;
    }

    public ArrayList<TraningModel> getTraningModel() {
        return traningModel;
    }

    public void setTraningModel(ArrayList<TraningModel> traningModel) {
        this.traningModel = traningModel;
    }

    public ArrayList<String> getInterestsModel() {
        return interestsModel;
    }

    public void setInterestsModel(ArrayList<String> interestsModel) {
        this.interestsModel = interestsModel;
    }


public  <T> void  toSString(ArrayList<T> cc)
{
    for(T x: cc)
        System.out.println(x.toString());
}
    public static void Object_Writer(MainHolder mainHolder,String filename)
    {

        String fileName = MainActivity.CV_PATH+filename;


        try(
                FileOutputStream fs = new FileOutputStream(fileName);
                ObjectOutputStream os = new ObjectOutputStream(fs);
        ) {
            os.writeObject(mainHolder);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Zapisano obiekt do pliku");



    }


    public static MainHolder Obcjet_Reader(String fileName)
    {
        MainHolder mainHolder=null;

        try(
                FileInputStream fis = new FileInputStream(MainActivity.CV_PATH+fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            mainHolder = (MainHolder) ois.readObject();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(mainHolder != null) {
            System.out.println("Wczytano dane o: ");
        }

return mainHolder;
    }
}
