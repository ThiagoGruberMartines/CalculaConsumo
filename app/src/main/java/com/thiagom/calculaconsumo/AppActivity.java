package com.thiagom.calculaconsumo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AppActivity extends AppCompatActivity {
    private EditText km;
    private EditText lt;
    private TextView consumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        km = findViewById(R.id.kmRodado);
        lt = findViewById(R.id.ltAbastecido);
        consumo = findViewById(R.id.resultado);
    }
    public void CalculaConsumo(View view){
        Double valor1 = 0.0;
        Double valor2 = 0.0;
        try {
            valor1 = Double.parseDouble(km.getText().toString());
        } catch (Exception e) {
            valor1 = 0.0;
        }
        try {
            valor2 = Double.parseDouble(lt.getText().toString());
        } catch (Exception e) {
            valor2 = 0.0;
        }
        consumo.setText(String.valueOf(valor1 / valor2));
    }

}