package com.guillermo.videojuegos.listaVideojuegos.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.guillermo.videojuegos.R;
import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.presenter.PresentadorListaVideojuegos;

public class ListaVideojuegos extends AppCompatActivity implements ContratoListaVideojuegos.View {
    private PresentadorListaVideojuegos presentadorListaVideojuegos;
    final boolean respuesta=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //cargamos el layout
        setContentView(R.layout.activity_lista_videojuegos);
        //iniciamos los componentes
        initComponents();
        //creamos el presentador
        presentadorListaVideojuegos = new PresentadorListaVideojuegos(this);

    }

    private void initComponents() {
        //iniciamos todos los componentes de la vista
    }

    @Override
    public void success() {

    }

    @Override
    public void error() {

    }
}