package com.example.muslimapps.Rest;

import com.example.muslimapps.Model.AsmaulHusna;
import com.example.muslimapps.Model.Ayat;
import com.example.muslimapps.Model.Surat;
import com.example.muslimapps.Model.Tahlil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("99c279bb173a6e28359c/data")
    Call<List<Surat>> getData();

    @GET("99c279bb173a6e28359c/surat/{nomor}")
    Call<List<Ayat>> getAyat(
            @Path("nomor") String nomor);


    @GET("api/tahlil")
    Call<TahlilResponse> getTahlil();

    @GET("api/asmaulhusna")
    Call<AsmaulhusnaResponse> getAsmaulHusna();


}
