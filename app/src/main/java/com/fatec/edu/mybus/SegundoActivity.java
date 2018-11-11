package com.fatec.edu.mybus;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.lang.CharSequence;

import java.util.ArrayList;
import java.util.Arrays;

public class SegundoActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView l2;
    String resultado;
    Itinerario itinerario;
    ArrayAdapter<String> adapter2;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_descricao);
        Bundle bundle = getIntent().getExtras();
      // resultado = "Itinerario"+bundle.getString("Itinerario");
        itinerario = (Itinerario) bundle.getSerializable("selecionado");

        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        l2 = (ListView) findViewById(R.id.listView2);
        t2=(TextView) findViewById(R.id.textView2);
        t3=(TextView) findViewById(R.id.textView8);
        t4=(TextView) findViewById(R.id.itinerario);
        t5 = (TextView) findViewById(R.id.segsexta);
        t6 = (TextView) findViewById(R.id.sabados);
        t7 = (TextView) findViewById(R.id.domingofer);



//        if(bundle !=null){

            mToolbar.setTitle(getResources().getString(R.string.app_name));
          //  mToolbar.setTitle(bundle.getString("Itinerario"));
            t2.setText("LINHA: "+itinerario.getNumeroLinhas());
            t3.setText("SENTIDO: "+itinerario.getSentido());
            t4.setText("ITINERÁRIO: "+itinerario.getRuas());
            t5.setText("SEGUNDA A SEXTA: "+itinerario.getHorarioSemanal());
            t6.setText("SABÁDOS: "+itinerario.getHorarioSabado());
            t7.setText("DOMINGOS E FERIADOS: "+itinerario.getHorarioDomingoFeriado());
          //  l2.setFilterText(bundle.getString("Itinerario"));

 //       }





    }
}
