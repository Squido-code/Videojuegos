package com.guillermo.videojuegos.listaVideojuegos.contract;

import com.guillermo.videojuegos.beans.Videojuego;

import java.util.ArrayList;

public interface ContratoListaVideojuegos {
    interface View{
        void success();
        void error();
    }
    interface Presenter{
        void getJuegos();

    }
    interface Model{
        void getjuegosWS(OnLstJuegosListener onLstJuegosListener);
        /*Reactivo*/
        interface OnLstJuegosListener{
            void onFinished(ArrayList<Videojuego> juegos);
            void onFailure(String error);
        }
    }
}
