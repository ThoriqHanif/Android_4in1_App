package com.thoriq.assesmengenap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Reading3Activity extends AppCompatActivity {

    ImageView ivBack, ivNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading3);

        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ivNext = findViewById(R.id.ivNext);
        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Reading3Activity.this, MateriActivity.class));
                Toast.makeText(Reading3Activity.this, "Course telah selesai", Toast.LENGTH_LONG).show();
            }
        });
    }
}