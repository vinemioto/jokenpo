package com.example.vine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vine.Banco.UsuarioBd;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView lista;
    UsuarioBd bdHelper;
    ArrayList<Usuario> listview_Usuarios;
    Usuario usuario;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        lista = (ListView) findViewById(R.id.listview_Usuarios);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Usuario usuarioEscolhido = (Usuario) adapter.getItemAtPosition(position);

                Intent i = new Intent(Main2Activity.this, Cadastro.class);
                i.putExtra("usuario-escolhido", usuarioEscolhido);
                startActivity(i);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                usuario = (Usuario) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar Este Usuario");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                bdHelper = new UsuarioBd(Main2Activity.this);
                bdHelper.deletarUsuario(usuario);
                bdHelper.close();
                carregarUsuario();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarUsuario();
    }

    public void carregarUsuario(){
        bdHelper = new UsuarioBd(Main2Activity.this);
        listview_Usuarios = bdHelper.getLista();
        bdHelper.close();

        if (listview_Usuarios != null){
            adapter = new ArrayAdapter<Usuario>(Main2Activity.this, android.R.layout.simple_list_item_1, listview_Usuarios);
            lista.setAdapter(adapter);
        }
        //  finish();
    }

}