package com.example.edson.receita_oo_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReceitasActivity extends AppCompatActivity {

    EditText nomeReceita, item1, item2, item3, preparo;
    Button salvar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);

        nomeReceita = (EditText) findViewById(R.id.edtNome);
        item1 = (EditText) findViewById(R.id.edtingrediente);
        item2 = (EditText) findViewById(R.id.edtingrediente2);
        item3 = (EditText) findViewById(R.id.edtingrediente3);
        preparo = (EditText) findViewById(R.id.edtingrediente3);
        salvar = (Button) findViewById(R.id.btn_salvar);
        cancelar = (Button) findViewById(R.id.btn_cancelar);



    }

    public void salvar (View view){

        if((nomeReceita.getText().toString().isEmpty() || item1.getText().toString().isEmpty() ||item2.getText().toString().isEmpty() || item3.getText().toString().isEmpty() || preparo.getText().toString().isEmpty())) {

            Toast.makeText(getApplicationContext(), "Preencha todos os Campos", Toast.LENGTH_LONG).show();
        }else {
            Receitas receita = new Receitas(nomeReceita.getText().toString(),
                    item1.getText().toString(),
                    item2.getText().toString(),
                    item3.getText().toString(),
                    preparo.getText().toString());

            Intent intent = new Intent();
            intent.putExtra("receita", receita);
            setResult(1, intent);
            finish();
        }

    }

    public  void cancelar (View view){

        Intent intent = new Intent();
        setResult(2, intent);

        finish();
    }
}
