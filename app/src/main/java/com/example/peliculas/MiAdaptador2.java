package com.example.peliculas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class MiAdaptador2 extends RecyclerView.Adapter<MiAdaptador2.MyViewHolder2>implements View.OnClickListener {

    ArrayList<Pelicula>pelisCompletas;
    private View.OnClickListener listener2;

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener2=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener2!=null){
            listener2.onClick(v);
        }
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{

        private TextView titulo2;
        private TextView director2;
        private TextView fecha;
        private TextView duracion;
        private TextView sala;
        ImageView caratula;
        ImageView imgEdad;
        CheckBox corazon;

        public MyViewHolder2(View viewElemento) {
            super(viewElemento);
            this.titulo2 = viewElemento.findViewById(R.id.textViewTitulo2);
            this.director2 = viewElemento.findViewById(R.id.textViewDirector2);
            this.fecha = viewElemento.findViewById(R.id.textViewsfecha);
            this.duracion = viewElemento.findViewById(R.id.textViewDuracion2);
            this.sala = viewElemento.findViewById(R.id.textViewSala2);
            this.caratula = viewElemento.findViewById(R.id.imageViewCaratula2);
            this.imgEdad = viewElemento.findViewById(R.id.imageViewEdad2);
            this.corazon = viewElemento.findViewById(R.id.corazon);

        }
    }

    public MiAdaptador2(ArrayList<Pelicula> pelisCompletas) {
        this.pelisCompletas = pelisCompletas;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptador2,parent, false);
        MyViewHolder2 mvh2=new MyViewHolder2(elemento);
        elemento.setOnClickListener((View.OnClickListener) this);
        return mvh2;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        Pelicula pel=this.pelisCompletas.get(position);
     holder.titulo2.setText(pel.getTitulo());
     holder.director2.setText("Director: "+pel.getDirector());
     holder.fecha.setText("Fecha: "+pel.getFecha().getDate()+"-"+(pel.getFecha().getMonth()+1)+"-"+(pel.getFecha().getYear()));
     holder.duracion.setText("Duracion: "+pel.getDuracion());
     holder.sala.setText("Sala: "+pel.getSala());
     holder.caratula.setImageResource(pel.getPortada());
     holder.imgEdad.setImageResource(pel.getClasi());
     holder.corazon.setChecked(pel.getFavorita());

     if(pel.favorita){
        holder.corazon.setVisibility(View.VISIBLE);
     }else{
         holder.corazon.setVisibility(View.INVISIBLE);
     }
    }

    @Override
    public int getItemCount() {
        return this.pelisCompletas.size();
    }
}
