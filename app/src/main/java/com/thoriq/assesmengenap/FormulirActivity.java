
package com.thoriq.assesmengenap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class FormulirActivity extends Activity implements AdapterView.OnItemSelectedListener {

    CardView cvSimpan, btnClear;
    private EditText etnama, etEmail, etAlamat, etNo;
    ImageView ivBack;
    Spinner sGender, sAgama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir);

        etnama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etEmail = findViewById(R.id.etEmail);
        etNo = findViewById(R.id.etNo);
        cvSimpan = findViewById(R.id.simpan);
        sGender = findViewById(R.id.sGender);
        sAgama = findViewById(R.id.sAgama);
        sGender.setOnItemSelectedListener(this);
        sAgama.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> gender = new ArrayList<String>();
        gender.add("Laki - Laki");
        gender.add("Perempuan");

        List<String> agama = new ArrayList<String>();
        agama.add("Islam");
        agama.add("Kristen");
        agama.add("Katholik");
        agama.add("Budha");
        agama.add("Hindu");
        agama.add("Konghucu");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);
        ArrayAdapter<String> agamaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, agama);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        agamaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sGender.setAdapter(dataAdapter);
        sAgama.setAdapter(agamaAdapter);

        cvSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = etnama.getText().toString();
                String a = etAlamat.getText().toString();
                String e = etEmail.getText().toString();
                String no = etNo.getText().toString();

                Intent intent = new Intent(FormulirActivity.this, HasilActivity.class);


                intent.putExtra("Gender",String.valueOf(sGender.getSelectedItem()));
                intent.putExtra("Agama",String.valueOf(sAgama.getSelectedItem()));
                intent.putExtra("Nama", n);
                intent.putExtra("Alamat", a);
                intent.putExtra("Email", e);
                intent.putExtra("No", no);

                startActivity(intent);
            }
        });

        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnama.setText("");
                etNo.setText("");
                etEmail.setText("");
                etAlamat.setText("");
                Toast.makeText(FormulirActivity.this, "Data telah dihapus", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?>  parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}