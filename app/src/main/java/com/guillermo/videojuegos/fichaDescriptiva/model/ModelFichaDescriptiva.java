package com.guillermo.videojuegos.fichaDescriptiva.model;

import android.os.AsyncTask;

import com.guillermo.videojuegos.beans.Ficha;
import com.guillermo.videojuegos.fichaDescriptiva.contract.ContratoFichaDescriptiva;
import com.guillermo.videojuegos.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModelFichaDescriptiva implements ContratoFichaDescriptiva.Model {
    //    https://api.rawg.io/api/games/ + id del juego
    private final String URL = "https://api.rawg.io/api/games/";
    private ArrayList<Ficha> listaArrayFicha;
    private OnLstFichaListener onLstFichaListener;
    private String idFicha;

    @Override
    public void getDescripcionWS(OnLstFichaListener onLstFichaListener, String idFicha) {
        this.onLstFichaListener = onLstFichaListener;
        this.idFicha = idFicha;
    }

    class TareasegudoPlano extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            Post post = new Post();
            String UrlCompleta = URL + idFicha;
            try {
                JSONObject objectMovies = post.getServerDataGetObject(UrlCompleta);
                JSONArray listaficha = objectMovies.getJSONArray("results");
                listaArrayFicha = Ficha.getArrayListFromJSON(listaficha);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            if (listaArrayFicha != null && listaArrayFicha.size() > 0) {
                onLstFichaListener.onResolve(listaArrayFicha);
            } else {
                onLstFichaListener.onReject("Error al traer los datos del servidor");
            }
        }
    }
}
