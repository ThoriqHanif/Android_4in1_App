package com.thoriq.assesmengenap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Materi1Activity extends AppCompatActivity {

    ImageView ivback;
    CardView course1, cvFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi1);

        ivback = findViewById(R.id.ivBack);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        course1 = findViewById(R.id.course1);
        course1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Materi1Activity.this, Reading1Activity.class));
            }
        });

        cvFav = findViewById(R.id.cvFav);
        cvFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Materi1Activity.this, "Berhasil menambah Favorite", Toast.LENGTH_LONG).show();
            }
        });


    }
}