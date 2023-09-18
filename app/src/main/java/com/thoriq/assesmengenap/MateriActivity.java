package com.thoriq.assesmengenap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MateriActivity extends AppCompatActivity {

    ImageView ivBack;
    CardView btnMateri1, btnMateri2, btnMateri3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnMateri1 = findViewById(R.id.btnMateri1);
        btnMateri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MateriActivity.this, Materi1Activity.class));
            }
        });
        btnMateri2 = findViewById(R.id.btnMateri2);
        btnMateri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MateriActivity.this, Materi2Activity.class));
            }
        });

        btnMateri3 = findViewById(R.id.btnMateri3);
        btnMateri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MateriActivity.this, Materi3Activity.class));
            }
        });
    }
}