package com.guillermo.videojuegos.listaVideojuegos.model;

import android.os.AsyncTask;

import com.guillermo.videojuegos.beans.Videojuego;
import com.guillermo.videojuegos.listaVideojuegos.contract.ContratoListaVideojuegos;
import com.guillermo.videojuegos.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModelListaVideojuegos
        implements ContratoListaVideojuegos.Model {
    private String url;
    private ArrayList<Videojuego> listaArrayJuegos;
    private OnLstJuegosListener onLstJuegosListener;


    @Override
    public void getjuegosWS(OnLstJuegosListener onLstJuegosListener) {
        this.onLstJuegosListener = onLstJuegosListener;
        url = "https://api.rawg.io/api/games?platforms=4&key=0b839d953789459bba3eac8865198928";
        TareasegudoPlano task = new TareasegudoPlano();
        task.execute();
    }

    @Override
    public void getjuegosfilterWS(OnLstJuegosListener onLstJuegosListener, String filtro) {
        this.onLstJuegosListener = onLstJuegosListener;
        String urlBase = "https://api.rawg.io/api/games?platforms=4&key=0b839d953789459bba3eac8865198928";
        String urlFiltro = "&genres=" + filtro;
        url = urlBase + urlFiltro;
        TareasegudoPlano task = new TareasegudoPlano();
        task.execute();
    }


    class TareasegudoPlano extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            Post post = new Post();
            try {
                JSONObject objectJuegos = post.getServerDataGetObject(url);
                JSONArray listaJuegos = objectJuegos.getJSONArray("results");
                listaArrayJuegos = Videojuego.getArrayListFromJSON(listaJuegos);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            if (listaArrayJuegos != null && listaArrayJuegos.size() > 0) {
                onLstJuegosListener.onResolve(listaArrayJuegos);
            } else {
                onLstJuegosListener.onReject("Error al traer los datos del servidor");
            }
        }
    }
}

