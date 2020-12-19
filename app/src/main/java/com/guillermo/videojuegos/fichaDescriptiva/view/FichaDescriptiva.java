package com.guillermo.videojuegos.fichaDescriptiva.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.guillermo.videojuegos.R;
import com.guillermo.videojuegos.beans.Ficha;
import com.guillermo.videojuegos.fichaDescriptiva.contract.ContratoFichaDescriptiva;
import com.guillermo.videojuegos.fichaDescriptiva.presenter.PresenterFichaDescriptiva;
import com.squareup.picasso.Picasso;

public class FichaDescriptiva extends AppCompatActivity implements ContratoFichaDescriptiva.View {
    private String juegoId;
    private PresenterFichaDescriptiva presenterFichaDescriptiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_descriptiva);
        getIncomingIntent();
        presenterFichaDescriptiva = new PresenterFichaDescriptiva(this);
        presenterFichaDescriptiva.getFicha(juegoId);

    }

    private void getIncomingIntent() {
        Boolean isComplete = getIntent().hasExtra("juego_id");
        if (isComplete) {
            String idJuego = getIntent().getStringExtra("juego_id");
            this.juegoId = idJuego;
        }
    }

    private void setFicha(String urlImagen, String nombre, String descripcion) {
        TextView tvNombreFicha = findViewById(R.id.txtNombreFicha);
        tvNombreFicha.setText(nombre);
        TextView tvDescripcionFicha = findViewById(R.id.txtdescription);
        tvDescripcionFicha.setText(descripcion);

        ImageView ivFicha = findViewById(R.id.imagenVideoJuegoFicha);
        Picasso.get().load(urlImagen).into(ivFicha);
    }

    @Override
    public void success(Ficha ficha) {
        String nombre = ficha.getNombre();
        String descripcion = ficha.getDescription();
        String urlImagen = ficha.getUrlImagen();
        setFicha(urlImagen, nombre, descripcion);
    }

    @Override
    public void error(String mensage) {
        Toast.makeText(this, "error al mostrar los datos", Toast.LENGTH_SHORT).show();
    }

    public String getJuegoId() {
        return juegoId;
    }
}