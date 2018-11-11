package com.fatec.edu.mybus;
import  com.fatec.edu.mybus.Itinerario;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.fatec.edu.mybus.ListaAdapterItinerario;
import java.lang.CharSequence;
import com.fatec.edu.mybus.ListaAdapterColunas;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    ListView l1;
    ListaAdapterItinerario adapter ;

    ArrayList<Itinerario> arrayList;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;




    Itinerario o1;
    Itinerario o2;
    Itinerario o3;


    Button btn1;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        e1 = (EditText)findViewById(R.id.editText);
        l1 = (ListView)findViewById(R.id.listView);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();







        initiList();
   //     initiListFiltrada();
        l1.setVisibility(View.GONE);
        btn1  = (Button)findViewById(R.id.button1) ;

        inserindoTexto();


        //clicar no texto retornado
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
                //intent.putExtra("Itinerario",arrayList.get(i).nomeDaRua+arrayList.get(i).numeroLinhas);

              //  Bundle bundle = new Bundle();
             //   bundle.putSerializable("selecionado",arrayList.get(i));
                intent.putExtra("selecionado",arrayList.get(i));
                startActivity(intent);
            }

        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TerceiraActivity.class);

                Bundle bundle = new Bundle();
                filtraBusca();
                bundle.putSerializable("filtrado",arrayList);
                intent.putExtras(bundle);
                startActivity(intent);
                onRestart();
                initiList();
                l1.setVisibility(View.GONE);
                inserindoTexto();



            }
        });





    }



    public void searchItem(String textTosearch){ //filtra pesquisa quando digitada
        String maiuscula = textTosearch.toUpperCase() ;
        for(Iterator<Itinerario> iterator = arrayList.iterator();iterator.hasNext();) {
            Itinerario onibu = iterator.next();
 //           String teste = onibu.getSentido();




                if (!(onibu.getNumeroLinhas()+onibu.getSentido()+onibu.getNomeDaRua()).contains(maiuscula))
                    iterator.remove();


        }
        adapter.notifyDataSetChanged();


    }


    public void initiList(){   //inicia arrays, e adapter
        arrayList = new ArrayList<>();
        lerDataBase();

 //       arrayList = new ArrayList<Itinerario>();
        adapter = new ListaAdapterItinerario(this,arrayList);
        l1.setAdapter(adapter);

    }







    public void inserindoTexto(){
        //metodo de filtro do buscador
        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                l1.setVisibility(View.VISIBLE);

                //  MainActivity.this.adapter.getFilter().filter(tx);
//
                if (s.toString().equals("")) {
                    initiList();
                }
                else {
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





    }






/* ---------------------------------------------FILTRAGEMA------------------------------*/



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

        for(Iterator<Itinerario> iterator = arrayList.iterator(); iterator.hasNext();) {
            Itinerario onibu = iterator.next();

                if ((!onibu.getNumeroLinhas().equals(textTosearch))||(!onibu.getSentido().equals(textTosearch))||(!onibu.getNomeDaRua().equals(textTosearch))){
                    iterator.remove();
                }

        }
        adapter.notifyDataSetChanged();
    }


 /*-----------FIREBASE-------------*/

public  void  lerDataBase(){

    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            showData(dataSnapshot);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

}

public void showData(DataSnapshot dataSnapshot){
    for(DataSnapshot ds: dataSnapshot.getChildren()){
      //  Itinerario onibu = new Itinerario();
   //     onibu.setNomeDaRua(ds.child(linhaData).getValue(Itinerario.class).getNumeroLinhas());
   //     onibu.setNomeDaRua(ds.child(nomeData).getValue(Itinerario.class).getNumeroLinhas());
   //     onibu.setNomeDaRua(ds.child(sentidoData).getValue(Itinerario.class).getNumeroLinhas());
       Itinerario onibu = ds.getValue(Itinerario.class);
        arrayList.add(onibu);
    }


}

}