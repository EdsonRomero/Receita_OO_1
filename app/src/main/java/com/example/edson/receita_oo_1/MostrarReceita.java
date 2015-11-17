package com.example.edson.receita_oo_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MostrarReceita extends AppCompatActivity {

    TextView txMostrar,txIngredientes,txPreparo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_receita);

        txMostrar = (TextView)findViewById(R.id.txMostrar);
        txIngredientes = (TextView)findViewById(R.id.txIngrediente);
        txPreparo= (TextView)findViewById(R.id.txPreparo);

        Bundle intent = getIntent().getExtras();

        String nomeReceita = intent.getString("nomeReceita");
        String item1 = intent.getString("item1");
        String item2 = intent.getString("item2");
        String item3 = intent.getString("item3");
        String preparo = intent.getString("preparo");



        txMostrar.setText(nomeReceita);
        txIngredientes.setText(item1+", "+item2+", "+item3);
        txPreparo.setText(preparo);




    }
}
