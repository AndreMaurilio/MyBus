package com.fatec.edu.mybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;


public class TerceiraActivity extends AppCompatActivity {

    EditText e1;
    ListView l1, l2;
    ListaAdapterColunas adapter2;
    ArrayList<Itinerario> arrayList2;
    Itinerario o1;
    Itinerario o2;
    Itinerario o3;
    CheckBox num;
    CheckBox nom;
    CheckBox rua;
    String palavra;
    Toolbar mToolbar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        mToolbar2 = (Toolbar) findViewById(R.id.toolbar3);
        mToolbar2.setTitle(getResources().getString(R.string.app_name));
        l2 = (ListView)findViewById(R.id.listView3);
        Bundle bundleObject = getIntent().getExtras();
        arrayList2 = new ArrayList<Itinerario>();
        arrayList2 = (ArrayList<Itinerario>) bundleObject.getSerializable("filtrado");

        initiListFiltrada();
    //    searchItemFiltrado(palavra);
        l2.setAdapter(adapter2);





        /*---------------------CLICAR PARA DESCRICAO-------------------------*/

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TerceiraActivity.this, SegundoActivity.class);
                //intent.putExtra("Itinerario",arrayList.get(i).nomeDaRua+arrayList.get(i).numeroLinhas);

                //  Bundle bundle = new Bundle();
                //   bundle.putSerializable("selecionado",arrayList.get(i));
                intent.putExtra("selecionado",arrayList2.get(i));
                startActivity(intent);
            }

        });











    }



    public void initiListFiltrada() {   //inicia arrays, e adapter


        adapter2 = new ListaAdapterColunas(this, arrayList2);



    };


    public void filtraBusca(){


        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchItemFiltrado(s.toString());

            }
        });



    }



    public void searchItemFiltrado(String textTosearch){ //filtra pesquisa quando digitada

        for(Iterator<Itinerario> iterator = arrayList2.iterator(); iterator.hasNext();) {
            Itinerario onibu = iterator.next();
            if(num.isChecked()) {
                if (!onibu.getNumeroLinhas().equals(textTosearch)) {
                    iterator.remove();
                }
            }
            else if (nom.isChecked()){
                if (!onibu.getSentido().equals(textTosearch)) {
                    iterator.remove();
                }
            }
            else if (rua.isChecked()){
                if (!onibu.getNomeDaRua().equals(textTosearch)) {
                    iterator.remove();
                }

            }

        }
        adapter2.notifyDataSetChanged();

    };





}