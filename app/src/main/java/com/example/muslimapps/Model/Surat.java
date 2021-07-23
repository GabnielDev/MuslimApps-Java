package com.example.muslimapps.Model;

import com.google.gson.annotations.SerializedName;

public class Surat {
    
    private String arti;
    private String asma;
    private String ayat;
    private String nama;
    private String type;
    private String urut;
    private String audio;
    private String nomor;
    private String rukuk;
    private String keterangan;
    
    public Surat(String arti, String asma, String ayat, String nama, String type, String urut, String audio, String nomor, String rukuk, String keterangan) {
        this.arti = arti;
        this.asma = asma;
        this.ayat = ayat;
        this.nama = nama;
        this.type = type;
        this.urut = urut;
        this.audio = audio;
        this.nomor = nomor;
        this.rukuk = rukuk;
        this.keterangan = keterangan;
    }
    
    public Surat() {
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrut() {
        return urut;
    }

    public void setUrut(String urut) {
        this.urut = urut;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getRukuk() {
        return rukuk;
    }

    public void setRukuk(String rukuk) {
        this.rukuk = rukuk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
