package com.fatec.edu.mybus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaAdapterItinerario extends ArrayAdapter<Itinerario> {

    private Context contexto;
    private ArrayList<Itinerario> lista;


    public ListaAdapterItinerario(Context context, ArrayList<Itinerario>lista){
        super(context,0,lista);
        this.contexto = context;
        this.lista = lista;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Itinerario itiPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.list_onibus,null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText( itiPosicao.getNumeroLinhas()+" "+itiPosicao.getSentido()+" "+ itiPosicao.getNomeDaRua());

        return  convertView;

    }

}
