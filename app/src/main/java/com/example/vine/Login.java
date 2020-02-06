package com.example.vine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vine.Banco.UsuarioBd;

public class Login extends AppCompatActivity {
    private Button btncad, btnlogin, btncancel;
    private EditText tnome, tsenha;
    UsuarioBd bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btncad = findViewById(R.id.btncad);
        btnlogin = findViewById(R.id.btnlogin);
        btncancel = findViewById(R.id.btncancel);
        tnome = findViewById(R.id.login);
        tsenha = findViewById(R.id.password);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = tnome.getText().toString().trim();
                String senha = tsenha.getText().toString().trim();
                bdHelper = new UsuarioBd(Login.this);
                if(tnome.getText().length() == 0){
                    Toast.makeText(Login.this, "Vazio", Toast.LENGTH_SHORT).show();
                }

                if(tsenha.getText().length() == 0){
                    Toast.makeText(Login.this, "Vazio", Toast.LENGTH_SHORT).show();
                }

                Boolean res = bdHelper.checkUser(nome, senha);
                Intent intn = new Intent(Login.this, MainActivity.class);
                startActivity(intn);

                if (res) {
                    Intent it = new Intent(Login.this, MainActivity.class);
                    startActivity(it);

                } else {
                    Toast.makeText(Login.this, "LOGIN OU SENHA INVALIDOS", Toast.LENGTH_SHORT).show();
                    Intent inten = new Intent(Login.this, Main2Activity.class);
                    startActivity(inten);
                }
              /*  Intent it = new Intent(Login.this, MainActivity.class);
                startActivity(it); */
            }
        });

        btncad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(Login.this, Cadastro.class);
                startActivity(inte);
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(Login.this, MainActivity.class);
                startActivity(inte);
            }
        });


    }

}
