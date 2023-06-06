package com.thiagom.calculaconsumo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thiagom.calculaconsumo.modelo.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDados();
            }
        });
    }

    private void recuperarDados() {
        if (etNome.getText().toString()==""||etEmail.getText().toString()==""||etSenha.getText().toString()==""){
            Toast.makeText(this, "Você deve preencher todos os dados!", Toast.LENGTH_LONG);
        } else {
            Usuario usuario = new Usuario();
            usuario.setNome(etNome.getText().toString());
            usuario.setEmail(etEmail.getText().toString());
            usuario.setSenha(etSenha.getText().toString());
        }
    }
}