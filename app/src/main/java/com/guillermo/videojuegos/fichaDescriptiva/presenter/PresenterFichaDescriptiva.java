package com.guillermo.videojuegos.fichaDescriptiva.presenter;

import com.guillermo.videojuegos.beans.Ficha;
import com.guillermo.videojuegos.fichaDescriptiva.FichaDescriptiva;
import com.guillermo.videojuegos.fichaDescriptiva.contract.ContratoFichaDescriptiva;
import com.guillermo.videojuegos.fichaDescriptiva.model.ModelFichaDescriptiva;

import java.util.ArrayList;

public class PresenterFichaDescriptiva implements ContratoFichaDescriptiva.Presenter {
    private final FichaDescriptiva fichaDescriptiva;
    private final String idFicha;
    private ModelFichaDescriptiva modelFichaDescriptiva;

    public PresenterFichaDescriptiva(FichaDescriptiva fichaDescriptiva) {
        this.fichaDescriptiva = fichaDescriptiva;
        idFicha = fichaDescriptiva.getJuegoId();
    }

    @Override
    public void getFicha() {
        modelFichaDescriptiva.getDescripcionWS(new ContratoFichaDescriptiva.Model.OnLstFichaListener() {
            @Override
            public void onResolve(ArrayList<Ficha> listaFicha) {
                fichaDescriptiva.success(listaFicha);
            }

            @Override
            public void onReject(String error) {
                fichaDescriptiva.error("Error al tratar los datos");
            }
        }, idFicha);
    }
}
