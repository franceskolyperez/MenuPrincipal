package com.franceskoly.menuprincipal;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostreAdapter extends RecyclerView.Adapter<PostreAdapter.PostreViewHolder>{

    ArrayList<Postre> listaPostre;
    Context context;

    public PostreAdapter(ArrayList<Postre> listaPostre, Context context) {
        this.listaPostre = listaPostre;
        this.context = context;
    }

    @NonNull
    @Override
    public PostreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mycContex = parent.getContext();
        int IdLayoutName = R.layout.item_listpostres;
        boolean attachParentRapido = false;

        LayoutInflater inflater = LayoutInflater.from(mycContex);
        View view = inflater.inflate(IdLayoutName, parent,attachParentRapido);

        PostreViewHolder holder = new PostreViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostreViewHolder holder, int position) {
        Glide.with(context).load("https://okdiario.com/img/recetas/2017/02/08/macarrones-con-chorizo.jpg").into(holder.imagen);
        holder.name.setText(listaPostre.get(position).getNomnbre_food());
    }

    @Override
    public int getItemCount() {
        return listaPostre.size();
    }

    class PostreViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView name;

        public PostreViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen = (ImageView) itemView.findViewById(R.id.imagen_postre);
            name = (TextView) itemView.findViewById(R.id.nombre_postre);
        }
    }
}
