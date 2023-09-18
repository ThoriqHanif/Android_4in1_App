package com.thoriq.assesmengenap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ProfileActivity extends AppCompatActivity {

    ImageView ivback;
    TextView contact;

    CardView cvIg, cvLink, cvGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivback = findViewById(R.id.ivBack);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        contact = findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://thoriqhanif.github.io/");
            }
        });

//        cvIg = findViewById(R.id.cvIg);
//        cvIg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gotoUrl("https://instagram.com/thoriqmuhhr_/");
//            }
//        });

        cvLink = findViewById(R.id.cvLink);
        cvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/in/thoriq-hanif/");
            }
        });

        cvGithub = findViewById(R.id.cvGithub);
        cvGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://github.com/ThoriqHanif/");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}