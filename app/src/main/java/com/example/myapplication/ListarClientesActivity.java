package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarClientesActivity extends AppCompatActivity {

    private ListView listView;
    private ClienteDAO dao;
    private List<Cliente> clientes;                               // vai receber todos os dados do cliente
    private List<Cliente> clientesFiltrados = new ArrayList<>();  //array lista onde tem todos os clientes inseridos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);

        listView = findViewById(R.id.lv_clientes);
        dao = new ClienteDAO(this);
        clientes = dao.obterTodosClientes();
        clientesFiltrados.addAll(clientes);

        ArrayAdapter<Cliente> adaptador = new ArrayAdapter<Cliente>(this,
                android.R.layout.simple_list_item_1, clientesFiltrados);
        listView.setAdapter(adaptador);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public void cadastrar(MenuItem item) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
    @Override
    public void onResume() {
        super.onResume();
        clientes = dao.obterTodosClientes();
        clientesFiltrados.clear();
        clientesFiltrados.addAll(clientes);
        listView.invalidateViews();
    }
}