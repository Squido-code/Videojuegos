package com.guillermo.videojuegos.listaVideojuegos.model;

import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.presenter.PresentadorListaVideojuegos;

public class ModelListaVideojuegos implements ContratoListaVideojuegos.Model {
    private PresentadorListaVideojuegos presentadorListaVideojuegos;

    public ModelListaVideojuegos(PresentadorListaVideojuegos presentadorListaVideojuegos) {
        this.presentadorListaVideojuegos = presentadorListaVideojuegos;
    }

    @Override
    public void getjuegosWS() {

    }
}
