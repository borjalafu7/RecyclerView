package com.borjalapa.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.borjalapa.recyclerview.modelos.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;
    RecyclerView rvLista;

    ArrayList<Persona> personas = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personas.add(new Persona("Paco","Peréz"));
        personas.add(new Persona("Sara","Lopez"));
        personas.add(new Persona("Roberto","Brasero"));

        rvLista = (RecyclerView) findViewById(R.id.lista);

        rvLista.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(getApplicationContext(),personas);

        rvLista.setAdapter(myAdapter);
    }

    public void addPesona(View view) {
        Persona p = new Persona("Ana","Gonzalez");
        myAdapter.setData(p);
    }
}