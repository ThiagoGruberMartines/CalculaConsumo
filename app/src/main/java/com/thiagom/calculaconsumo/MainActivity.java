package com.thiagom.calculaconsumo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnLogar;
    private Button btnCadastre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogar = findViewById(R.id.btnLogar);
        btnCadastre = findViewById(R.id.btnCadastre);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaLogar();
            }
        });

        btnCadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaCadastrar();
            }
        });
    }

    private void telaCadastrar() {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    private void telaLogar() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}