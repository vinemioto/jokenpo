package com.example.vine.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vine.Usuario;

import java.util.ArrayList;

public class UsuarioBd  extends SQLiteOpenHelper {

    private static final String DATABASE ="bdusuario";
    private  static final int VERSION = 1;


    public UsuarioBd (Context context){
        super(context, DATABASE,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String users = "CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "senha TEXT NOT NULL);";
        db.execSQL(users);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String users = "DROP TABLE IF EXISTS users";
        db.execSQL(users);
    }
    // aqui salva
    public void salvarUsuario(Usuario usuario){
        ContentValues values = new ContentValues();

        values.put("nome",usuario.getNome());
        values.put("senha",usuario.getSenha());

        getWritableDatabase().insert("users",null,values);
    }
    // metodo alterar concluído ↓ :D
    public void alterarUsuario(Usuario usuario){
        ContentValues values = new ContentValues();

        values.put("nome",usuario.getNome());
        values.put("senha",usuario.getSenha());


        String [] args = {usuario.getId().toString()};
        getWritableDatabase().update("users",values,"id=?",args);

    }

    public Boolean checkUser(String nome, String senha){
        String [] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();

        String selection = "nome =? and senha =?";
        String[] selectionArgs = {nome, senha};
        Cursor cursor = db.query("users", columns, selection, selectionArgs,null,null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0 ){ return true;
        } else return false;
    }


    public void deletarUsuario(Usuario usuario){
        String [] args = {usuario.getId().toString()};
        getWritableDatabase().delete("users","id=?",args);
    }

    // lista - mostrar

    public ArrayList<Usuario> getLista(){
        String [] columns ={"id","nome","senha"};
        Cursor cursor = getWritableDatabase().query("users",columns,null,null,null,null,null,null);
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        while (cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNome(cursor.getString(1));
            usuario.setSenha(cursor.getString(2));

            usuarios.add(usuario);
        }
        return usuarios;
    }



}