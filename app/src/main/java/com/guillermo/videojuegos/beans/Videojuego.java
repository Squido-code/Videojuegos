package com.guillermo.videojuegos.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Videojuego {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String BACKGROUND_IMAGE = "background_image";
    private int id;
    private String nombre;
    private String description;
    private String imagen;


    public static ArrayList<Videojuego> getArrayListFromJSON(JSONArray listaJuegos) {
        ArrayList<Videojuego> lista = null;
        try {
            if (listaJuegos != null && listaJuegos.length() > 0) {
                lista = new ArrayList<Videojuego>();
            }
            for (int i = 0; i < listaJuegos.length(); i++) {
                JSONObject json_data = listaJuegos.getJSONObject(i);
                Videojuego videojuego = new Videojuego();

                videojuego.setId(json_data.getInt(ID));
                videojuego.setNombre(json_data.getString(NAME));
//                videojuego.setDescription(json_data.getString(DESCRIPTION));
                videojuego.setImagen(json_data.getString(BACKGROUND_IMAGE));

                lista.add(videojuego);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
