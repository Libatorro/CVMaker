package com.example.sebastian.cvmaker.CV.Fragments.Models;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-07-07.
 */
public class PersonalModel  implements Serializable {

    private String photoUrl;
    private String name;
    private String serName;
    private String date;
    private String birthCity;
    private String email;

    public PersonalModel(String photoUrl, String name, String serName, String date, String birthCity, String email) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.serName = serName;
        this.date = date;
        this.birthCity = birthCity;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonlModel{" +
                "photoUrl='" + photoUrl + '\'' +
                ", name='" + name + '\'' +
                ", serName='" + serName + '\'' +
                ", date='" + date + '\'' +
                ", birthCity='" + birthCity + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
