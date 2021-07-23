package com.example.muslimapps.Model;

import com.google.gson.annotations.SerializedName;

public class AsmaulHusna {

    @SerializedName("index")
    private String index;
    @SerializedName("latin")
    private String latin;
    @SerializedName("arabic")
    private String arabic;
    @SerializedName("translation_id")
    private String translation_id;
    @SerializedName("translation_en")
    private String translation_en;

    public AsmaulHusna(String index, String latin, String arabic, String translation_id, String translation_en) {
        this.index = index;
        this.latin = latin;
        this.arabic = arabic;
        this.translation_id = translation_id;
        this.translation_en = translation_en;
    }

    public AsmaulHusna() {
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getTranslation_id() {
        return translation_id;
    }

    public void setTranslation_id(String translation_id) {
        this.translation_id = translation_id;
    }

    public String getTranslation_en() {
        return translation_en;
    }

    public void setTranslation_en(String translation_en) {
        this.translation_en = translation_en;
    }
}
