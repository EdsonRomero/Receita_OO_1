package com.example.edson.receita_oo_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_1 = 1;
    public static final int CONSTANTE_TELA_2 = 2;


    public static ArrayList<Receitas> minhasReceitas = new ArrayList<Receitas>();
    ListView listView;
    Button add;
    ReceitasAdapter adapter;
    int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView) findViewById(R.id.lst_Receitas);
        add = (Button) findViewById(R.id.btn_add);
        registerForContextMenu(listView);

       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, ReceitasActivity.class);

               startActivityForResult(intent, CONSTANTE_TELA_1);
           }
       });

        adapter = new ReceitasAdapter(this, android.R.layout.simple_list_item_1, minhasReceitas);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, MostrarReceita.class);

                String nomeReceita = adapter.getItem(position).getNomeReceita().toString();
                String item1 = adapter.getItem(position).getItem1().toString();
                String item2 = adapter.getItem(position).getItem2().toString();
                String item3 = adapter.getItem(position).getItem3().toString();
                String preparo = adapter.getItem(position).getModoPreparo().toString();

                intent.putExtra("nomeReceita", nomeReceita);
                intent.putExtra("item1", item1);
                intent.putExtra("item2", item2);
                intent.putExtra("item3", item3);
                intent.putExtra("preparo", preparo);


                startActivity(intent);
          }
      });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Bundle params = data.getExtras();
        if(params != null) {
            if (requestCode == CONSTANTE_TELA_1) {

                adapter.add((Receitas) data.getSerializableExtra("receita"));
                adapter.notifyDataSetChanged();

            } else if (requestCode == CONSTANTE_TELA_2) {

                minhasReceitas.set(posicao, (Receitas) data.getSerializableExtra("update"));
                adapter.notifyDataSetChanged();

            }
        }
        }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        posicao = info.position;

        menu.setHeaderTitle("Selecione");
        menu.add(0, v.getId(), 0, "Atualizar");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "Deletar");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Atualizar"){

            Intent intent = new Intent(MainActivity.this, UpdateReceitas.class);
            String nomeReceita = adapter.getItem(posicao).getNomeReceita().toString();
            String item1 = adapter.getItem(posicao).getItem1().toString();
            String item2 = adapter.getItem(posicao).getItem2().toString();
            String item3 = adapter.getItem(posicao).getItem3().toString();
            String preparo = adapter.getItem(posicao).getModoPreparo().toString();

            intent.putExtra("nomeReceita", nomeReceita);
            intent.putExtra("item1", item1);
            intent.putExtra("item2", item2);
            intent.putExtra("item3", item3);
            intent.putExtra("preparo", preparo);
            startActivityForResult(intent, CONSTANTE_TELA_2);

        }
        else if(item.getTitle()=="Deletar"){
            minhasReceitas.remove(posicao);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(),"Excluido",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }



}
