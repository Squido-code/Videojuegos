package com.guillermo.videojuegos.listaVideojuegos.model;

import android.os.AsyncTask;

import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ModelListaVideojuegos implements ContratoListaVideojuegos.Model {

    final Boolean resp = true;


    @Override
    public void getjuegosWS(OnLstJuegosListener onLstJuegosListener) {

    }
}

class TareasegudoPlano extends AsyncTask<String, Integer, Boolean> {

    @Override
    protected Boolean doInBackground(String... strings) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://rawg-video-games-database.p.rapidapi.com/games")
                .get()
                .addHeader("x-rapidapi-key", "13ff077075mshe0fedee2c2a91e3p146981jsn04ac3a5574e4")
                .addHeader("x-rapidapi-host", "rawg-video-games-database.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}


