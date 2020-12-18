package com.guillermo.videojuegos.listaVideojuegos.presenter;

import com.guillermo.videojuegos.beans.Videojuego;
import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.model.ModelListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.view.ListaVideojuegos;

import java.util.ArrayList;

public class PresentadorListaVideojuegos implements ContratoListaVideojuegos.Presenter {
    private final ListaVideojuegos listaVideojuegos;
    private final ModelListaVideojuegos modelListaVideojuegos;

    public PresentadorListaVideojuegos(ListaVideojuegos listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
        modelListaVideojuegos = new ModelListaVideojuegos();
    }

    @Override
    public void getJuegos() {
        modelListaVideojuegos.getjuegosWS(new ContratoListaVideojuegos.Model.OnLstJuegosListener() {
            @Override
            public void onResolve(ArrayList<Videojuego> juegos) {
                listaVideojuegos.success(juegos);
            }

            @Override
            public void onReject(String error) {
                listaVideojuegos.error("Error al tratar los datos");
            }
        });
    }
}
