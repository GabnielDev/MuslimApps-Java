package com.example.muslimapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CardView btnQuran, btnTahlil, btnAsmaul, btnPembuat;
    ImageSlider imageSlider;
    ImageView icAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.imageslider);
        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.alquran, null));
        images.add(new SlideModel(R.drawable.allah, null));
        images.add(new SlideModel(R.drawable.laillahailallah, null));
        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);

        btnQuran = findViewById(R.id.btnQuran);
        btnQuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuranActivity.class);
                startActivity(intent);
            }
        });

        btnTahlil = findViewById(R.id.btnTahlil);
        btnTahlil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TahlilActivity.class);
                startActivity(intent);
            }
        });

        btnAsmaul = findViewById(R.id.btnAsmaul);
        btnAsmaul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsmaulhusnaActivity.class);
                startActivity(intent);
            }
        });

        btnPembuat = findViewById(R.id.btnPembuat);
        btnPembuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GoogleMapActivity.class);
                startActivity(intent);
            }
        });

        icAbout = findViewById(R.id.icAbout);
        icAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}
