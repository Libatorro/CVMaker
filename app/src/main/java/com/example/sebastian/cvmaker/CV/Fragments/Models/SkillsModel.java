package com.example.sebastian.cvmaker.CV.Fragments.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sebastian on 2016-07-06.
 */
public class SkillsModel  implements Serializable,Parcelable {
    private String Skill_titile;
    private ArrayList<String> skill_values;

    protected SkillsModel(Parcel in) {
        Skill_titile = in.readString();
        skill_values = in.createStringArrayList();
    }

    public static final Creator<SkillsModel> CREATOR = new Creator<SkillsModel>() {
        @Override
        public SkillsModel createFromParcel(Parcel in) {
            return new SkillsModel(in);
        }

        @Override
        public SkillsModel[] newArray(int size) {
            return new SkillsModel[size];
        }
    };

    @Override
    public String toString() {
        return "SkillsModel{" +
                "Skill_titile='" + Skill_titile + '\'' +
                ", skill_values=" + skill_values +
                '}';
    }

    public String getSkill_titile() {
        return Skill_titile;
    }

    public void setSkill_titile(String skill_titile) {
        Skill_titile = skill_titile;
    }

    public ArrayList<String> getSkill_values() {
        return skill_values;
    }

    public void setSkill_values(ArrayList<String> skill_values) {
        this.skill_values = skill_values;
    }

    public SkillsModel(String skill_titile, ArrayList<String> skill_values) {

        Skill_titile = skill_titile;
        this.skill_values = skill_values;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Skill_titile);
        dest.writeStringList(skill_values);
    }
}
