package com.guillermo.videojuegos.fichaDescriptiva.presenter;

import com.guillermo.videojuegos.beans.Ficha;
import com.guillermo.videojuegos.fichaDescriptiva.contract.ContratoFichaDescriptiva;
import com.guillermo.videojuegos.fichaDescriptiva.model.ModelFichaDescriptiva;

public class PresenterFichaDescriptiva implements ContratoFichaDescriptiva.Presenter {
    private final ContratoFichaDescriptiva.View viewFicha;
    private final ModelFichaDescriptiva modelFichaDescriptiva;

    public PresenterFichaDescriptiva(ContratoFichaDescriptiva.View vistaFicha) {
        this.viewFicha = vistaFicha;
        this.modelFichaDescriptiva = new ModelFichaDescriptiva();
    }


    @Override
    public void getFicha(String idFicha) {
        modelFichaDescriptiva.getDescripcionWS(new ContratoFichaDescriptiva.Model.OnLstFichaListener() {
            @Override
            public void onResolve(Ficha fichaCompleta) {
                viewFicha.success(fichaCompleta);
            }

            @Override
            public void onReject(String error) {
                viewFicha.error("Error al acceder al los datos");
            }
        }, idFicha);
    }
}
