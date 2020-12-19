package com.guillermo.videojuegos.beans;

import org.json.JSONException;
import org.json.JSONObject;

public class Ficha {

    private String nombre;
    private String metacritic;
    private String released;
    private String description;


    public static Ficha getFichafromJSONObject(JSONObject jsonObject) {
        Ficha ficha = new Ficha();
        try {
            String nombre = jsonObject.getString("name");
            String metacritic = jsonObject.getString("metacritic");
            String released = jsonObject.getString("released");
            String description = jsonObject.getString("description");
            ficha.setNombre(nombre);
            ficha.setReleased(released);
            ficha.setMetacritic(metacritic);
            ficha.setDescription(description);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ficha;
    }
    //    public static ArrayList<Ficha> getArrayListFromJSON(JSONArray listaFicha) {
//        ArrayList<Ficha> lista = null;
//        try {
//            if (listaFicha != null && listaFicha.length() > 0) {
//                lista = new ArrayList<Ficha>();
//                for (int i = 0; i < listaFicha.length(); i++) {
//                    JSONObject json_data = listaFicha.getJSONObject(i);
//                    Ficha ficha = new Ficha();
//
//                    ficha.setNombre(json_data.getString(NAME));
//                    ficha.setMetacritic(json_data.getString(METACRITIC));
//                    ficha.setReleased(json_data.getString(RELEASED));
//
//                    lista.add(ficha);
//                 }
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return lista;
//    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
