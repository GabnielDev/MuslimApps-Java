package com.example.muslimapps.Model;

import com.google.gson.annotations.SerializedName;

public class Ayat {

    @SerializedName("ar")
    private String ar;
    @SerializedName("id")
    private String id;
    @SerializedName("tr")
    private String tr;
    @SerializedName("nomor")
    private String nomor;

    public Ayat() {
    }

    public Ayat(String ar, String id, String tr, String nomor) {
        this.ar = ar;
        this.id = id;
        this.tr = tr;
        this.nomor = nomor;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}
