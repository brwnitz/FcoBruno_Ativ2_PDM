package com.example.flexapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtGasolina, txtAlcool;
    Switch swtAditivada;
    Button btnCalcular;

    TextView tvResult;
    double etanol;
    double gasolina;

    boolean aditivada = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtGasolina = findViewById(R.id.txtGasolina);
        txtAlcool = findViewById(R.id.txtEtanol);
        swtAditivada = findViewById(R.id.swtAditivada);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResult = findViewById(R.id.tvResult);

        swtAditivada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    aditivada = true;
                }
                else {
                    aditivada = false;
                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gasolina = Double.parseDouble(txtGasolina.getText().toString());
                etanol = Double.parseDouble(txtAlcool.getText().toString());
                if (aditivada){
                    gasolina = gasolina*1.1;
                }
                if ((gasolina * 0.7) >= etanol){
                    tvResult.setText("Etanol é mais rentável");
                }
                else{
                    tvResult.setText("Gasolina é mais rentável");
                }
            }
        });
    }
}