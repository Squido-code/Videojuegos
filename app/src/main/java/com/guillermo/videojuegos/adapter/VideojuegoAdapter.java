package com.guillermo.videojuegos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guillermo.videojuegos.R;
import com.guillermo.videojuegos.beans.Videojuego;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class VideojuegoAdapter extends RecyclerView.Adapter<VideojuegoAdapter.JuegoViewHolder> {
    private final ArrayList<Videojuego> listaJuegos;

    public VideojuegoAdapter(ArrayList<Videojuego> juegos) {
        this.listaJuegos = juegos;
    }

    @NonNull
    @Override
    public JuegoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_videojuego, parent, false);

        return new JuegoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JuegoViewHolder holder, int position) {
        final Videojuego videojuego = listaJuegos.get(position);
        holder.nombre.setText(videojuego.getNombre());
        Picasso.get().load("https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg").into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class JuegoViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;

        public JuegoViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagenVideoJuego);
            nombre = v.findViewById(R.id.txtNombre);

        }
    }
}
