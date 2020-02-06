package com.example.vine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vine.Banco.UsuarioBd;

public class Cadastro extends AppCompatActivity {
    private Button bSalvar, bVoltar;
    private EditText tSenha, tLogin;
    Usuario editarUsuario, usuario;
    UsuarioBd bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuario = new Usuario();
        bdHelper = new UsuarioBd(Cadastro.this);

        Intent intent = getIntent();
        editarUsuario = (Usuario) intent.getSerializableExtra("usuario-escolhido");

        bSalvar = findViewById(R.id.btnsalvar);
        bVoltar = findViewById(R.id.button6);
        tLogin = findViewById(R.id.etLogin);
        tSenha = findViewById(R.id.etSenha);

        bVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Cadastro.this, Login.class);
                startActivity(it);
            }
        });

        if (editarUsuario !=null){
            bSalvar.setText("Modificar Usuario");

            tLogin.setText(editarUsuario.getNome());
            tSenha.setText(editarUsuario.getSenha());

            usuario.setId(editarUsuario.getId());

        }else{
            bSalvar.setText("Cadastrar Novo Usuario");
        }

        bSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(tLogin.getText().toString());
                usuario.setSenha(tSenha.getText().toString());

                if(bSalvar.getText().toString().equals("Cadastrar Novo Usuario")){
                    bdHelper.salvarUsuario(usuario);
                    bdHelper.close();
                }else{
                    bdHelper.alterarUsuario(usuario);
                    bdHelper.close();
                }
                Intent it = new Intent(Cadastro.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}
