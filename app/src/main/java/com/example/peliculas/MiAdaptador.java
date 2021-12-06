package com.example.peliculas;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder>implements View.OnClickListener {

    private View.OnClickListener listener;
    private int selectedPos;
    ArrayList<Pelicula>peliculas;
	//Comentario

    public void setOnClickListener(View.OnClickListener listener) {

        this.listener = listener;
    }

    public int getSelectedPos() {
        return selectedPos;
    }

    public void setSelectedPos(int selectedPos) {
        if(selectedPos==this.selectedPos){
            notifyItemChanged(this.selectedPos);
            this.selectedPos=RecyclerView.NO_POSITION;
        }else{
            if(this.selectedPos>=0) notifyItemChanged(this.selectedPos);
            this.selectedPos = selectedPos;
            notifyItemChanged(this.selectedPos);
        }

    }

    public MiAdaptador(ArrayList<Pelicula>pelicula){

        this.peliculas=pelicula;
    }

    @Override
    public void onClick(View v) {
       if(listener!=null){
           listener.onClick(v);
       }

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView titulo;
        private TextView director;
        ImageView imgCaratula;
        ImageView imgEdad;


        public MyViewHolder(View viewElemento) {
            super(viewElemento);
            this.titulo = viewElemento.findViewById(R.id.textViewTitulo2);
            this.director = viewElemento.findViewById(R.id.textViewDirector2);
            this.imgCaratula = viewElemento.findViewById(R.id.imageViewCaratula2);
            this.imgEdad = viewElemento.findViewById(R.id.imageViewEdad2);

        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View elemento= LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_individual,parent, false);
        MyViewHolder mvh=new MyViewHolder(elemento);
        elemento.setOnClickListener(this);
       selectedPos=RecyclerView.NO_POSITION;

        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Pelicula peli=this.peliculas.get(position);
        holder.titulo.setText(peli.getTitulo());
        holder.director.setText(peli.getDirector());
        holder.imgCaratula.setImageResource(peli.getPortada());
        holder.imgEdad.setImageResource(peli.getClasi());

    }

    @Override
    public int getItemCount() {
        return this.peliculas.size();
    }


}
