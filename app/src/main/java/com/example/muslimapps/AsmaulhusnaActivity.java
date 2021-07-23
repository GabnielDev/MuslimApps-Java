package com.example.muslimapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.muslimapps.Adapter.AsmaulHusnaAdapter;
import com.example.muslimapps.Model.AsmaulHusna;
import com.example.muslimapps.Rest.ApiClient;
import com.example.muslimapps.Rest.ApiInterface;
import com.example.muslimapps.Rest.AsmaulhusnaResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsmaulhusnaActivity extends AppCompatActivity {

    RecyclerView rvAsmaulhusna;
    ApiInterface apiInterface;
    AsmaulHusnaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmaulhusna);

        rvAsmaulhusna = findViewById(R.id.rv_asmaulhusna);
        apiInterface = ApiClient.getClient1().create(ApiInterface.class);

        Call<AsmaulhusnaResponse> call = apiInterface.getAsmaulHusna();
        call.enqueue(new Callback<AsmaulhusnaResponse>() {
            @Override
            public void onResponse(Call<AsmaulhusnaResponse> call, Response<AsmaulhusnaResponse> response) {
                AsmaulhusnaResponse asmaulhusnaResponse = response.body();
                List<AsmaulHusna> asmaulHusnas = new ArrayList<>(Arrays.asList(asmaulhusnaResponse.getData1()));
                adapter = new AsmaulHusnaAdapter(asmaulHusnas);
                rvAsmaulhusna.setAdapter(adapter);
                rvAsmaulhusna.setLayoutManager(new LinearLayoutManager(AsmaulhusnaActivity.this));
                rvAsmaulhusna.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<AsmaulhusnaResponse> call, Throwable t) {

            }
        });

    }
}
