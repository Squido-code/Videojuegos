package com.guillermo.videojuegos.listaVideojuegos.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guillermo.videojuegos.R;
import com.guillermo.videojuegos.adapter.VideojuegoAdapter;
import com.guillermo.videojuegos.beans.Videojuego;
import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.presenter.PresentadorListaVideojuegos;

import java.util.ArrayList;


public class ListaVideojuegos extends AppCompatActivity implements ContratoListaVideojuegos.View {
    private PresentadorListaVideojuegos presentadorListaVideojuegos;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_videojuegos);
        presentadorListaVideojuegos = new PresentadorListaVideojuegos(this);
        presentadorListaVideojuegos.getJuegos();
        context = getBaseContext();
    }


    @Override
    public void success(ArrayList<Videojuego> juegos) {
        recyclerView = findViewById(R.id.recyclerVideojuegos);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        VideojuegoAdapter adapter = new VideojuegoAdapter(juegos, context);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void error(String mensage) {
        Toast.makeText(this, "error al mostrar los datos", Toast.LENGTH_SHORT).show();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}