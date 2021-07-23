package com.example.muslimapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.muslimapps.Adapter.SuratAdapter;
import com.example.muslimapps.Model.Ayat;
import com.example.muslimapps.Model.Surat;
import com.example.muslimapps.Rest.ApiClient;
import com.example.muslimapps.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.GestureDetector.*;

public class QuranActivity extends AppCompatActivity {

    RecyclerView rv_surat;
    ApiInterface apiInterface;
    SuratAdapter adapter;

    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);

        rv_surat = findViewById(R.id.rv_surat);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Surat>> listCall = apiInterface.getData();
        listCall.enqueue(new Callback<List<Surat>>() {
            @Override
            public void onResponse(Call<List<Surat>> call, final Response<List<Surat>> response) {
                final List<Surat> surats = response.body();
                adapter = new SuratAdapter(QuranActivity.this, surats);
                rv_surat.setAdapter(adapter);
                rv_surat.setLayoutManager(new LinearLayoutManager(QuranActivity.this));
                rv_surat.setHasFixedSize(true);



//                rv_surat.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//                    GestureDetector gestureDetector = new GestureDetector(QuranActivity.this, new GestureDetector.SimpleOnGestureListener(){
//                        @Override
//                        public boolean onSingleTapUp(MotionEvent e) {
//                            return true;
//                        }
//                    });
//
//                    @Override
//                    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                        View child = rv.findChildViewUnder(e.getX(), e.getY());
//                        if (child != null && gestureDetector.onTouchEvent(e)) {
//                            int position = rv.getChildAdapterPosition(child);
//                            Toast.makeText(QuranActivity.this, "Surat" + surats.get(position).getNama() + "selected", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(QuranActivity.this, AyatActivity.class);
//
//                            intent.putExtra("path", surats.get(position).getNomor());
//
//                            QuranActivity.this.startActivity(intent);
//                        }
//                        return false;
//                    }
//
//                    @Override
//                    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//
//                    }
//
//                    @Override
//                    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//                    }
//                });


            }

            @Override
            public void onFailure(Call<List<Surat>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());

            }
        });



    }

    private void Surat() {

    }
}
