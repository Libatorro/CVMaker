package com.example.sebastian.cvmaker.CV.Fragments.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-07-06.
 */
public class EduciatonModel implements Parcelable,Serializable {
private  String SchoolName;
   private String detalis_title;
    private String detalis_city;
    private String detalis_startDate;
    private String detalis_finishDate;

    protected EduciatonModel(Parcel in) {
        SchoolName = in.readString();
        detalis_title = in.readString();
        detalis_city = in.readString();
        detalis_startDate = in.readString();
        detalis_finishDate = in.readString();
    }

    public static final Creator<EduciatonModel> CREATOR = new Creator<EduciatonModel>() {
        @Override
        public EduciatonModel createFromParcel(Parcel in) {
            return new EduciatonModel(in);
        }

        @Override
        public EduciatonModel[] newArray(int size) {
            return new EduciatonModel[size];
        }
    };

    public EduciatonModel(String schoolName) {
        SchoolName = schoolName;
    }

    @Override
    public String toString() {
        return "EduciatonModel{" +
                "SchoolName='" + SchoolName + '\'' +
                ", detalis_title='" + detalis_title + '\'' +
                ", detalis_city='" + detalis_city + '\'' +
                ", detalis_startDate='" + detalis_startDate + '\'' +
                ", detalis_finishDate='" + detalis_finishDate + '\'' +
                '}';
    }

    public EduciatonModel(String schoolName, String detalis_title, String detalis_city, String detalis_startDate, String detalis_finishDate) {
        SchoolName = schoolName;
        this.detalis_title = detalis_title;
        this.detalis_city = detalis_city;
        this.detalis_startDate = detalis_startDate;
        this.detalis_finishDate = detalis_finishDate;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getDetalis_title() {
        return detalis_title;
    }

    public void setDetalis_title(String detalis_title) {
        this.detalis_title = detalis_title;
    }

    public String getDetalis_city() {
        return detalis_city;
    }

    public void setDetalis_city(String detalis_city) {
        this.detalis_city = detalis_city;
    }

    public String getDetalis_startDate() {
        return detalis_startDate;
    }

    public void setDetalis_startDate(String detalis_startDate) {
        this.detalis_startDate = detalis_startDate;
    }

    public String getDetalis_finishDate() {
        return detalis_finishDate;
    }

    public void setDetalis_finishDate(String detalis_finishDate) {
        this.detalis_finishDate = detalis_finishDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SchoolName);
        dest.writeString(detalis_title);
        dest.writeString(detalis_city);
        dest.writeString(detalis_startDate);
        dest.writeString(detalis_finishDate);
    }
}
