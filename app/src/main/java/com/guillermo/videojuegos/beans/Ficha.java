package com.guillermo.videojuegos.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ficha {
    private static final String NAME = "name";
    private static final String METACRITIC = "metacritic";
    private static final String RELEASED = "released";
    private String nombre;
    private String metacritic;
    private String released;

    public static ArrayList<Ficha> getArrayListFromJSON(JSONArray listaFicha) {
        ArrayList<Ficha> lista = null;
        try {
            if (listaFicha != null && listaFicha.length() > 0) {
                lista = new ArrayList<Ficha>();
            }
            for (int i = 0; i < listaFicha.length(); i++) {
                JSONObject json_data = listaFicha.getJSONObject(i);
                Ficha ficha = new Ficha();

                ficha.setNombre(json_data.getString(NAME));
                ficha.setMetacritic(json_data.getString(METACRITIC));
                ficha.setReleased(json_data.getString(RELEASED));

                lista.add(ficha);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(String metacritic) {
        this.metacritic = metacritic;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }
}
