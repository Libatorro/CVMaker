package com.example.sebastian.cvmaker.CV.Fragments.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-07-06.
 */
public class ExperienceModel implements Serializable,Parcelable {
    private   String Job_name;
    private String expDuties;
    private String expJobTitle;
    private String expStartDate;
    private String expFinishDate;

    public ExperienceModel(String job_name) {
        Job_name = job_name;
    }

    public ExperienceModel() {

    }

    protected ExperienceModel(Parcel in) {
        Job_name = in.readString();
        expDuties = in.readString();
        expJobTitle = in.readString();
        expStartDate = in.readString();
        expFinishDate = in.readString();
    }

    public static final Creator<ExperienceModel> CREATOR = new Creator<ExperienceModel>() {
        @Override
        public ExperienceModel createFromParcel(Parcel in) {
            return new ExperienceModel(in);
        }

        @Override
        public ExperienceModel[] newArray(int size) {
            return new ExperienceModel[size];
        }
    };

    @Override
    public String toString() {
        return "ExperienceModel{" +
                "Job_name='" + Job_name + '\'' +
                ", expDuties='" + expDuties + '\'' +
                ", expJobTitle='" + expJobTitle + '\'' +
                ", expStartDate='" + expStartDate + '\'' +
                ", expFinishDate='" + expFinishDate + '\'' +
                '}';
    }

    public ExperienceModel(String job_name, String expDuties, String expJobTitle, String expStartDate, String expFinishDate) {
        Job_name = job_name;
        this.expDuties = expDuties;
        this.expJobTitle = expJobTitle;
        this.expStartDate = expStartDate;
        this.expFinishDate = expFinishDate;
    }

    public String getJob_name() {
        return Job_name;
    }

    public void setJob_name(String job_name) {
        Job_name = job_name;
    }

    public String getExpDuties() {
        return expDuties;
    }

    public void setExpDuties(String expDuties) {
        this.expDuties = expDuties;
    }

    public String getExpJobTitle() {
        return expJobTitle;
    }

    public void setExpJobTitle(String expJobTitle) {
        this.expJobTitle = expJobTitle;
    }

    public String getExpStartDate() {
        return expStartDate;
    }

    public void setExpStartDate(String expStartDate) {
        this.expStartDate = expStartDate;
    }

    public String getExpFinishDate() {
        return expFinishDate;
    }

    public void setExpFinishDate(String expFinishDate) {
        this.expFinishDate = expFinishDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Job_name);
        dest.writeString(expDuties);
        dest.writeString(expJobTitle);
        dest.writeString(expStartDate);
        dest.writeString(expFinishDate);
    }
}
