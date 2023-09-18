package com.thoriq.assesmengenap;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class KonversiActivity extends AppCompatActivity {

    EditText etSuhu;
    ImageView ivBack;
    Spinner Opsi;
    CardView btnConvert, btnClear;
    ConstraintLayout layoutHasil;
    TextView tvhasilHitung, tvhasilKonversi, tvRumus, tvRumusnya;
    private final String Pilihan[] = {"Pilih Konversi","Celsius to Kelvin", "Celsius to Fahrenheit", "Celsius to Reamur", "Kelvin to Celsius",
            "Kelvin to Fahrenheit", "Kelvin to Reamur", "Fahrenheit to Celsius", "Fahrenheit to Kelvin",
            " Fahrenheit to Reamur", "Reamur to Celsius", " Reamur to Kelvin", " Reamur to Fahrenheit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi);

        etSuhu = findViewById(R.id.etSuhu);
        Opsi = findViewById(R.id.Opsi);
        btnConvert = findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnClear);
        layoutHasil = findViewById(R.id.layoutHasil);
        tvhasilHitung = findViewById(R.id.tvhasilHitung);
        tvhasilKonversi = findViewById(R.id.tvhasilKonversi);
        tvRumus = findViewById(R.id.tvRumus);
        tvRumusnya = findViewById(R.id.tvRumusnya);

        ArrayAdapter adapter = new ArrayAdapter(
                KonversiActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                Pilihan
        );

        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Opsi.setAdapter(adapter);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSuhu.setText("");
                tvhasilKonversi.setText("");
                tvhasilHitung.setText("");
                tvRumusnya.setText("");
                tvRumus.setText("");

                if(layoutHasil.getVisibility() == View.VISIBLE){
                    layoutHasil.setVisibility(View.GONE);
                }
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getSuhu = etSuhu.getText().toString();

                if(getSuhu.isEmpty()){
                    Toast.makeText(KonversiActivity.this, "Silahkan Isi Suhu Awal!", Toast.LENGTH_SHORT).show();
                }else{
                    if(layoutHasil.getVisibility() == View.GONE){
                        layoutHasil.setVisibility(View.VISIBLE);
                    }

                    double suhu = Double.valueOf(etSuhu.getText().toString());
                    double hasil;
                    String rumus, rumus1;
                    int Spinner = Opsi.getSelectedItemPosition();
                    switch (Spinner){
                        case 0 :
                            if(layoutHasil.getVisibility() == View.VISIBLE){
                                layoutHasil.setVisibility(View.GONE);
                            }
                            Toast.makeText(KonversiActivity.this, "Silahkan pilih Opsi Konversi!", Toast.LENGTH_SHORT).show();
                            break;
                        case 1://\u00B0Celsius to Kelvin
                            hasil = suhu + 273;
                            rumus = "\u00B0Celcius + 273";
                            rumus1 = suhu + " + 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil );
                            break;
                        case 2://\u00B0Celsius to \u00B0Fahrenheit
                            hasil = 9.0/5.0 * suhu + 32;
                            rumus = "9.0/5.0 * \u00B0Celsius + 32";
                            rumus1 = "9.0/5.0 * "+ suhu +"+ 32";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 3://\u00B0Celsius to \u00B0Reamur
                            hasil = 4.0/5.0 * suhu;
                            rumus = "4.0/5.0 * \u00B0Celsius";
                            rumus1 = "4.0/5.0 * "+suhu;
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 4://Kelvin to \u00B0Celsius
                            hasil = suhu - 273;
                            rumus = "Kelvin - 273";
                            rumus1 = suhu+" - 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 5://Kelvin to \u00B0Fahrenheit
                            hasil = 9.0/5.0 * (suhu - 273) + 32;
                            rumus = "9.0/5.0 * (Kelvin - 273) + 32";
                            rumus1 = "9.0/5.0 * (" +suhu+" - 273) + 32";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 6://Kelvin to \u00B0Reamur
                            hasil = 4.0/5.0 * (suhu - 273);
                            rumus = "4.0/5.0 * (Kelvin - 273)";
                            rumus1 = "4.0/5.0 * ("+suhu+" - 273)";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 7://\u00B0Fahrenheit to \u00B0Celsius
                            hasil = 5.0/9.0 * (suhu - 32);
                            rumus = "5.0/9.0 * (\u00B0Fahrenheit - 32)";
                            rumus1 = "5.0/9.0 * ("+suhu+" - 32)";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 8://\u00B0Fahrenheit to Kelvin
                            hasil = 5.0/9.0 * (suhu - 32) + 273;
                            rumus = "5.0/9.0 * (\u00B0Fahrenheit - 32) + 273";
                            rumus1 = "5.0/9.0 * ("+suhu+" - 32) + 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 9://\u00B0Fahrenheit to \u00B0Reamur
                            hasil = 4.0/9.0 * (suhu - 32);
                            rumus = "4.0/9.0 * (\u00B0Fahrenheit - 32)";
                            rumus1 = "4.0/9.0 * ("+suhu+" - 32)";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 10://\u00B0Reamur to \u00B0Celsius
                            hasil = 5.0/4.0 * suhu;
                            rumus = "5.0/4.0 * \u00B0Reamur";
                            rumus1 = "5.0/4.0 * " + suhu;
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 11://\u00B0Reamur to Kelvin
                            hasil = 5.0/4.0 * suhu + 273;
                            rumus = "5.0/4.0 * \u00B0Reamur + 273";
                            rumus1 = "5.0/4.0 * "+suhu+" + 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                        case 12://\u00B0Reamur to \u00B0Fahrenheit
                            hasil = (9.0/4.0 * suhu) + 32;
                            rumus = "(9.0/4.0 * \u00B0Reamur) + 32";
                            rumus1 = "(9.0/4.0 * "+suhu+") + 32";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumusnya.setText("= "+rumus + "\n= " + rumus1 + "\n= " +hasil );
                            tvRumus.setText("Rumus : ");
                            break;
                    }

                }
            }
        });

    }
}