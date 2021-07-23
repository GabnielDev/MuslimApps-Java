package com.example.muslimapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.muslimapps.Adapter.AyatAdapter;
import com.example.muslimapps.Model.Ayat;
import com.example.muslimapps.Model.Surat;
import com.example.muslimapps.Rest.ApiClient;
import com.example.muslimapps.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AyatActivity extends AppCompatActivity {

    RecyclerView rv_ayat;
    ApiInterface apiInterface;
    AyatAdapter adapter;

    String path;
    String parameter;

    public static final String EXTRA_NO = "path";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat);



        rv_ayat = findViewById(R.id.rv_ayat);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        getAyat();
    }

    private void getAyat() {
        path = getIntent().getStringExtra("path");

        Call<List<Ayat>> call = apiInterface.getAyat(path);
        call.enqueue(new Callback<List<Ayat>>() {
            @Override
            public void onResponse(Call<List<Ayat>> call, Response<List<Ayat>> response) {
//                final List<Ayat> ayats = response.body();
//                adapter = new AyatAdapter(AyatActivity.this, ayats);
//                rv_ayat.setAdapter(adapter);
//                rv_ayat.setLayoutManager(new LinearLayoutManager(AyatActivity.this));
//                rv_ayat.setHasFixedSize(true);

                if (response.isSuccessful()) {
                    List<Ayat> ayats = response.body();
                    adapter = new AyatAdapter( AyatActivity.this, ayats);
                    rv_ayat.setLayoutManager(new LinearLayoutManager(AyatActivity.this));
                    rv_ayat.setAdapter(adapter);
                    rv_ayat.setHasFixedSize(true);
                }

            }

            @Override
            public void onFailure(Call<List<Ayat>> call, Throwable t) {

            }
        });
    }

}