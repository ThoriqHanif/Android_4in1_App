package com.thoriq.assesmengenap;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class KalkulatorActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvHasil,tvOperasi;
    MaterialButton btnClear,btn_kurungBuka,btn_kurungTutup;
    MaterialButton btnBagi,btn_kali,btn_plus,btn_minus,btn_equal;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton btn_clearAll,buttonDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        tvHasil = findViewById(R.id.tvHasil);
        tvOperasi = findViewById(R.id.tvOperasi);

        tombol(btnClear,R.id.btn_clear);
        tombol(btn_kurungBuka,R.id.btn_kurungBuka);
        tombol(btn_kurungTutup,R.id.btn_kurungTutup);
        tombol(btnBagi,R.id.btn_bagi);
        tombol(btn_kali,R.id.btn_kali);
        tombol(btn_plus,R.id.btn_plus);
        tombol(btn_minus,R.id.btn_minus);
        tombol(btn_equal,R.id.btn_equal);
        tombol(button0,R.id.button_0);
        tombol(button1,R.id.button_1);
        tombol(button2,R.id.button_2);
        tombol(button3,R.id.button_3);
        tombol(button4,R.id.button_4);
        tombol(button5,R.id.button_5);
        tombol(button6,R.id.button_6);
        tombol(button7,R.id.button_7);
        tombol(button8,R.id.button_8);
        tombol(button9,R.id.button_9);
        tombol(btn_clearAll,R.id.btn_clearAll);
        tombol(buttonDot,R.id.button_dot);

    }

    void tombol(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = tvOperasi.getText().toString();

        if(buttonText.equals("AC")){
            tvOperasi.setText("");
            tvHasil.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            tvOperasi.setText(tvHasil.getText());
            return;
        }
        if(buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
        }else{
            dataToCalculate = dataToCalculate+buttonText;
        }
        tvOperasi.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            tvHasil.setText(finalResult);
        }

    }

    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }

}