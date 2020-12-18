package com.guillermo.videojuegos.fichaDescriptiva;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.guillermo.videojuegos.R;
import com.guillermo.videojuegos.beans.Ficha;
import com.guillermo.videojuegos.fichaDescriptiva.contract.ContratoFichaDescriptiva;
import com.guillermo.videojuegos.fichaDescriptiva.presenter.PresenterFichaDescriptiva;

import java.util.ArrayList;

public class FichaDescriptiva extends AppCompatActivity implements ContratoFichaDescriptiva.View {
    private String juegoId;
    private PresenterFichaDescriptiva presenterFichaDescriptiva;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_descriptiva);
        presenterFichaDescriptiva = new PresenterFichaDescriptiva(this);
        presenterFichaDescriptiva.getFicha();
    }

    private void getIncomingIntent() {
        Boolean isComplete = getIntent().hasExtra("juego_id");
        if (isComplete) {
            String idJuego = getIntent().getStringExtra("nombre");
            this.juegoId = idJuego;
        }
    }

    @Override
    public void success(ArrayList<Ficha> fichas) {

    }

    @Override
    public void error(String mensage) {
        Toast.makeText(this, "error al mostrar los datos", Toast.LENGTH_SHORT).show();
    }

    public String getJuegoId() {
        return juegoId;
    }
}