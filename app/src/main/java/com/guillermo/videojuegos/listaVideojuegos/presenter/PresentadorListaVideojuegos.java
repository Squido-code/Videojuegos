package com.guillermo.videojuegos.listaVideojuegos.presenter;

import com.guillermo.videojuegos.listaVideojuegos.model.ModelListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.view.ListaVideojuegos;

public class PresentadorListaVideojuegos {
    private final ListaVideojuegos listaVideojuegos;
    private final ModelListaVideojuegos modelListaVideojuegos;

    public PresentadorListaVideojuegos(ListaVideojuegos listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
        modelListaVideojuegos = new ModelListaVideojuegos(this);
    }
}
