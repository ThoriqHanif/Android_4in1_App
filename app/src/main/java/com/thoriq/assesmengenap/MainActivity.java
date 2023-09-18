package com.thoriq.assesmengenap;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CardView cvformulir, cvkalkulator, cvProfile, cvKonversi, cvMateri1, cvMateri2, cvMateri3;
    CircleImageView ivProfile;
    TextView tvDate;

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

//    ImageSlider imageSlider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");

        SimpleDateFormat sdft = new SimpleDateFormat(" HH:mm:ss");
        String Date = sdf.format(new Date());

        tvDate.setText(Date);

        cvformulir = findViewById(R.id.cvFormulir);
        cvformulir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FormulirActivity.class));
            }
        });

        cvkalkulator = findViewById(R.id.cvKalkulator);
        cvkalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KalkulatorActivity.class));
            }
        });

        cvKonversi = findViewById(R.id.cvKonversi);
        cvKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KonversiActivity.class));
            }
        });

        cvProfile = findViewById(R.id.cvProfile);
        cvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        ivProfile = findViewById(R.id.ivprofile);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

//        cvMateri1 = findViewById(R.id.btnMateri1);
//        cvMateri1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MateriActivity.class));
//            }
//        });
//
//        cvMateri2 = findViewById(R.id.btnMateri2);
//        cvMateri2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MateriActivity.class));
//            }
//        });
//
//        cvMateri3 = findViewById(R.id.btnMateri3);
//        cvMateri3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MateriActivity.class));
//            }
//        });

        models = new ArrayList<>();
        models.add(new Model(R.drawable.mockup1, "Android Development", "Android Development"));
        models.add(new Model(R.drawable.web2, "Website Development", "Website Development"));
        models.add(new Model(R.drawable.dekstop, "Dekstop Development", "Dekstop Development"));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(0, 0, 0, 0);
        viewPager.setPageMargin(0);

//        Integer[] colors_temp = {
//                getResources().getColor(R.color.primary),
//                getResources().getColor(R.color.primary),
//                getResources().getColor(R.color.primary)
//        };

//        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

//                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
//                    viewPager.setBackgroundColor(
//
//                            (Integer) argbEvaluator.evaluate(
//                                    positionOffset,
//                                    colors[position],
//                                    colors[position + 1]
//                            )
//                    );
//                }
//
//                else {
//                    viewPager.setBackgroundColor(colors[colors.length - 1]);
//                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}