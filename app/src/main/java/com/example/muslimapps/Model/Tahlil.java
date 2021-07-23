package com.example.muslimapps.Model;

import com.google.gson.annotations.SerializedName;

public class Tahlil {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("arabic")
    private String arabic;
    @SerializedName("translation")
    private String translation;

    public Tahlil(String id, String title, String arabic, String translation) {
        this.id = id;
        this.title = title;
        this.arabic = arabic;
        this.translation = translation;
    }

    public Tahlil() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
