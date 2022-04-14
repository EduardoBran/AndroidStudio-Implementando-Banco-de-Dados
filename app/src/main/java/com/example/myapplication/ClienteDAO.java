package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public Connection connection;
    public SQLiteDatabase banco;

    public ClienteDAO(Context context){
        connection = new Connection(context);
        banco = connection.getWritableDatabase();
    }
    // Criar método para inserir um cliente
    // Criar um contentValues para pegar os valores que vão ser inseridos na tabela cliente
    public long inserir(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());

        return banco.insert("cliente", null, values);
    }
    public List<Cliente> obterTodosClientes() {

        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = banco.query("cliente", new String[] {"id", "nome"},
                null, null, null, null, null);

        while(cursor.moveToNext()) {
            Cliente c = new Cliente();
            c.setId(cursor.getInt(0));
            c.setNome(cursor.getString(1));
            clientes.add(c);
        }
        return clientes;
    }
}