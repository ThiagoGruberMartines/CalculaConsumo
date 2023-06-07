package com.thiagom.calculaconsumo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;
import com.thiagom.calculaconsumo.modelo.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private Button btnCadastrar;
    private Usuario usuario;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        mAuth = FirebaseAuth.getInstance();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDados();
                criarLogin();
            }
        });
    }

    private void criarLogin() {
        mAuth.createUserWithEmailAndPassword(usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    usuario.setId(user.getUid());
                    usuario.salvarDados();
                    startActivity(new Intent(CadastroActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(CadastroActivity.this, "Erro ao cadastrar-se!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void recuperarDados() {
        if (etNome.getText().toString()==""||etEmail.getText().toString()==""||etSenha.getText().toString()==""){
            Toast.makeText(this, "Você deve preencher todos os dados!", Toast.LENGTH_LONG);
        } else {
            usuario = new Usuario();
            usuario.setNome(etNome.getText().toString());
            usuario.setEmail(etEmail.getText().toString());
            usuario.setSenha(etSenha.getText().toString());
        }
    }
}