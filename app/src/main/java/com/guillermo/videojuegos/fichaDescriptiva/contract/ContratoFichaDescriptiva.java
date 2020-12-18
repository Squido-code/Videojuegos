package com.guillermo.videojuegos.fichaDescriptiva.contract;

import com.guillermo.videojuegos.beans.Ficha;

import java.util.ArrayList;

public interface ContratoFichaDescriptiva {
    interface View {
        void success(ArrayList<Ficha> fichas);

        void error(String mensage);
    }

    interface Presenter {
        void getFicha();

    }

    interface Model {
        void getDescripcionWS(OnLstFichaListener onLstJuegosListener, String idFicha);

        /*Reactivo*/
        interface OnLstFichaListener {
            void onResolve(ArrayList<Ficha> listaFicha);

            void onReject(String error);
        }
    }
}
