package com.fatec.edu.mybus;

import com.fatec.edu.mybus.Itinerario;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaAdapterColunas extends ArrayAdapter<Itinerario>{

    private Context contexto;
    private ArrayList<Itinerario> lista;
  //  private int mResource;


    public ListaAdapterColunas(Context contexto, ArrayList<Itinerario>lista){
        super(contexto,0,lista);
        this.contexto = contexto;
        this.lista = lista;
     //   this.mResource =resource;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        Itinerario itiPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.adapater_view_layout,null);

        TextView tvLinha = (TextView)convertView.findViewById(R.id.textView4);
        TextView tvNome = (TextView)convertView.findViewById(R.id.textView5);
        TextView tvSentido = (TextView)convertView.findViewById(R.id.textView6);


        tvLinha.setText(itiPosicao.getNumeroLinhas());
        tvNome.setText(itiPosicao.getNomeDaRua());
        tvSentido.setText(itiPosicao.getSentido());


        return convertView;



    }

}
