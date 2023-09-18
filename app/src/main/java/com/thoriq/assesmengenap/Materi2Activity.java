package com.thoriq.assesmengenap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Materi2Activity extends AppCompatActivity {

    ImageView ivback;
    CardView course2, cvFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi2);

        ivback = findViewById(R.id.ivBack);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        course2 = findViewById(R.id.course2);
        course2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Materi2Activity.this, Reading2Activity.class));
            }
        });

        cvFav = findViewById(R.id.cvFav);
        cvFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Materi2Activity.this, "Berhasil menambah Favorite", Toast.LENGTH_LONG).show();
            }
        });
    }
}