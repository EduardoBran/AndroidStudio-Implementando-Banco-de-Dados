package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private Button btnGravar;
    private ClienteDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = (EditText) findViewById(R.id.et_nome);
        btnGravar = (Button) findViewById(R.id.btn_gravar);

        dao = new ClienteDAO(this);
    }
    public void salvar(View v){

        Cliente c = new Cliente();
        c.setNome(etNome.getText().toString());
        long id = dao.inserir(c);
        Toast.makeText(this,"Cliente cadastrado com id: " + id, Toast.LENGTH_SHORT).show();
    }
}