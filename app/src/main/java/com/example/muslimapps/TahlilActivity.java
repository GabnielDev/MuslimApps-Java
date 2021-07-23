package com.example.muslimapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.muslimapps.Adapter.TahlilAdapter;
import com.example.muslimapps.Model.Tahlil;
import com.example.muslimapps.Rest.ApiClient;
import com.example.muslimapps.Rest.ApiInterface;
import com.example.muslimapps.Rest.TahlilResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TahlilActivity extends AppCompatActivity {

    RecyclerView rv_tahlil;
    ApiInterface apiInterface;
    TahlilAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahlil);

        rv_tahlil = findViewById(R.id.rv_tahlil);
        apiInterface = ApiClient.getClient1().create(ApiInterface.class);

        Call<TahlilResponse> call = apiInterface.getTahlil();
//       Call<TahlilResponse> call = apiInterface.getTahlil();
       call.enqueue(new Callback<TahlilResponse>() {
           @Override
           public void onResponse(Call<TahlilResponse> call, Response<TahlilResponse> response) {
               TahlilResponse tahlilResponse = response.body();
               List<Tahlil> tahlils = new ArrayList<>(Arrays.asList(tahlilResponse.getData()));
               adapter = new TahlilAdapter(tahlils);
               rv_tahlil.setAdapter(adapter);
               rv_tahlil.setLayoutManager(new LinearLayoutManager(TahlilActivity.this));
               rv_tahlil.setHasFixedSize(true);
           }

           @Override
           public void onFailure(Call<TahlilResponse> call, Throwable t) {

           }
       });

//        Call<List<Tahlil>> call = apiInterface.getTahlil();
//        call.enqueue(new Callback<List<Tahlil>>() {
//            @Override
//            public void onResponse(Call<List<Tahlil>> call, Response<List<Tahlil>> response) {
//                List<Tahlil> tahlils = response.body();
//                adapter = new TahlilAdapter(TahlilActivity.this, tahlils);
//                rv_tahlil.setAdapter(adapter);
//                rv_tahlil.setLayoutManager(new LinearLayoutManager(TahlilActivity.this));
//                rv_tahlil.setHasFixedSize(true);
//            }
//
//            @Override
//            public void onFailure(Call<List<Tahlil>> call, Throwable t) {
//
//            }
//        });


    }
}
