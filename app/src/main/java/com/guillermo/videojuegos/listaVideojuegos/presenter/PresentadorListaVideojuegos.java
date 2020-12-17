package com.guillermo.videojuegos.listaVideojuegos.presenter;

import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.model.ModelListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.view.ListaVideojuegos;

public class PresentadorListaVideojuegos implements ContratoListaVideojuegos.Presenter {
    private final ListaVideojuegos listaVideojuegos;
    private final ModelListaVideojuegos modelListaVideojuegos;

    public PresentadorListaVideojuegos(ListaVideojuegos listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
        modelListaVideojuegos = new ModelListaVideojuegos(this);
    }

    @Override
    public void getJuegos() {

    }
}
