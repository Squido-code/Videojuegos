package com.guillermo.videojuegos.listaVideojuegos.presenter;

import com.guillermo.videojuegos.beans.Videojuego;
import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.model.ModelListaVideojuegos;
import com.guillermo.videojuegos.listaVideojuegos.view.ListaVideojuegos;

import java.util.ArrayList;
import java.util.HashMap;

public class PresentadorListaVideojuegos implements ContratoListaVideojuegos.Presenter {
    private final ListaVideojuegos listaVideojuegos;
    private final ModelListaVideojuegos modelListaVideojuegos;
    private String filtro;

    public PresentadorListaVideojuegos(ListaVideojuegos listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
        modelListaVideojuegos = new ModelListaVideojuegos();
    }

    @Override
    public void getJuegos(Boolean isFiltrado) {
        //creamos hasmap para connvertir el filtro en una id entendible para la API
        HashMap<String, String> filtroId = new HashMap<>();
        filtroId.put("acción", "4");
        filtroId.put("aventura", "3");
        filtroId.put("RPG", "5");
        filtroId.put("Estrategia", "10");
        if (isFiltrado) {
            modelListaVideojuegos.getjuegosfilterWS(new ContratoListaVideojuegos.Model.OnLstJuegosListener() {
                @Override
                public void onResolve(ArrayList<Videojuego> juegos) {
                    listaVideojuegos.success(juegos);
                }

                @Override
                public void onReject(String error) {
                    listaVideojuegos.error("Error al tratar los datos");
                }
            }, filtroId.get(filtro));
        } else {
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

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
