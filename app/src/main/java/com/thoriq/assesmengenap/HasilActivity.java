package com.thoriq.assesmengenap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class HasilActivity extends AppCompatActivity {

    ImageView back;
    MaterialButton btnClear, btnSimpan;
    EditText etNama, etAlamat, etEmail, etNo, etGender, etAgama ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etEmail = findViewById(R.id.etEmail);
        etNo = findViewById(R.id.etNo);
        etGender = findViewById(R.id.etGender);
        etAgama = findViewById(R.id.etAgama);

        String nama = getIntent().getStringExtra("Nama");
        String alamat = getIntent().getStringExtra("Alamat");
        String email = getIntent().getStringExtra("Email");
        String no = getIntent().getStringExtra("No");


        etNama.setText(nama);
        etAlamat.setText(alamat);
        etEmail.setText(email);
        etNo.setText(no);

        EditText  editText=(EditText) findViewById(R.id.etGender);
        Bundle bundle=getIntent().getExtras();
        String gender=bundle.get("Gender").toString();
        etGender.setText(gender);

        EditText  etAgama=(EditText) findViewById(R.id.etAgama);
        Bundle bAgama=getIntent().getExtras();
        String agama=bAgama.get("Agama").toString();
        etAgama.setText(agama);

        back = findViewById(R.id.ivBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HasilActivity.this, "Data anda telah disimpan", Toast.LENGTH_LONG).show();
                startActivity(new Intent(HasilActivity.this, MainActivity.class));
            }
        });

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNama.setText("");
                etNo.setText("");
                etEmail.setText("");
                etAlamat.setText("");
                etGender.setText("");
                etAgama.setText("");
                Toast.makeText(HasilActivity.this, "Data telah dihapus", Toast.LENGTH_LONG).show();

            }
        });
    }
}