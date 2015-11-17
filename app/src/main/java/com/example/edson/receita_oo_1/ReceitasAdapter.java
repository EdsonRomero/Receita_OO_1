package com.example.edson.receita_oo_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Edson on 12/11/2015.
 */
public class ReceitasAdapter extends ArrayAdapter<Receitas> {

    public ReceitasAdapter(Context context, int resource, List<Receitas> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View linha = LayoutInflater.from(getContext()).inflate(R.layout.linha_adapter_receita,null);

        TextView txtNome=(TextView) linha.findViewById(R.id.txtNomeReceita);


        Receitas p = getItem(position);
        txtNome.setText(p.getNomeReceita());

        return linha;

    }
}
