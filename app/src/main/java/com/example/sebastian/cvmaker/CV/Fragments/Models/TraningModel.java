package com.example.sebastian.cvmaker.CV.Fragments.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-07-06.
 */
public class TraningModel implements Serializable,Parcelable {
    private String  name_Traning;
    private String date_Traning;
    private String extraDealis_Traning;
    private String url_for_cerfytication;

    public TraningModel(String name_Traning, String url_for_cerfytication) {
        this.name_Traning = name_Traning;
        this.url_for_cerfytication = url_for_cerfytication;
    }

    protected TraningModel(Parcel in) {
        name_Traning = in.readString();
        date_Traning = in.readString();
        extraDealis_Traning = in.readString();
        url_for_cerfytication = in.readString();
    }

    public static final Creator<TraningModel> CREATOR = new Creator<TraningModel>() {
        @Override
        public TraningModel createFromParcel(Parcel in) {
            return new TraningModel(in);
        }

        @Override
        public TraningModel[] newArray(int size) {
            return new TraningModel[size];
        }
    };

    public String getName_Traning() {

        return name_Traning;
    }

    public void setName_Traning(String name_Traning) {
        this.name_Traning = name_Traning;
    }

    public String getDate_Traning() {
        return date_Traning;
    }

    public void setDate_Traning(String date_Traning) {
        this.date_Traning = date_Traning;
    }

    public String getExtraDealis_Traning() {
        return extraDealis_Traning;
    }

    public void setExtraDealis_Traning(String extraDealis_Traning) {
        this.extraDealis_Traning = extraDealis_Traning;
    }

    public String getUrl_for_cerfytication() {
        return url_for_cerfytication;
    }

    public void setUrl_for_cerfytication(String url_for_cerfytication) {
        this.url_for_cerfytication = url_for_cerfytication;
    }

    @Override
    public String toString() {
        return "TraningModel{" +
                "name_Traning='" + name_Traning + '\'' +
                ", date_Traning='" + date_Traning + '\'' +
                ", extraDealis_Traning='" + extraDealis_Traning + '\'' +
                ", url_for_cerfytication='" + url_for_cerfytication + '\'' +
                '}';
    }

    public TraningModel(String name_Traning, String date_Traning, String extraDealis_Traning, String url_for_cerfytication) {
        this.name_Traning = name_Traning;
        this.date_Traning = date_Traning;
        this.extraDealis_Traning = extraDealis_Traning;
        this.url_for_cerfytication = url_for_cerfytication;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_Traning);
        dest.writeString(date_Traning);
        dest.writeString(extraDealis_Traning);
        dest.writeString(url_for_cerfytication);
    }
}
