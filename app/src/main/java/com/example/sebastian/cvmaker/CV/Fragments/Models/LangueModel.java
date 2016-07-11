package com.example.sebastian.cvmaker.CV.Fragments.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-07-06.
 */
public class LangueModel implements Serializable,Parcelable {
    private String langue;
    private String spinnerValue;

    protected LangueModel(Parcel in) {
        langue = in.readString();
        spinnerValue = in.readString();
    }

    public static final Creator<LangueModel> CREATOR = new Creator<LangueModel>() {
        @Override
        public LangueModel createFromParcel(Parcel in) {
            return new LangueModel(in);
        }

        @Override
        public LangueModel[] newArray(int size) {
            return new LangueModel[size];
        }
    };

    @Override
    public String toString() {
        return "LangueModel{" +
                "langue='" + langue + '\'' +
                ", spinnerValue='" + spinnerValue + '\'' +
                '}';
    }

    public String getSpinnerValue() {
        return spinnerValue;
    }

    public void setSpinnerValue(String spinnerValue) {
        this.spinnerValue = spinnerValue;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public LangueModel(String langue, String spinnerValue) {

        this.langue = langue;
        this.spinnerValue = spinnerValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(langue);
        dest.writeString(spinnerValue);
    }
}
