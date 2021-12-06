package com.example.peliculas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Sinopsis extends AppCompatActivity {

        static ArrayList<Pelicula> pelix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis);
        pelix=MainActivity.peliculas;
        int posicion=getIntent().getIntExtra("posicion",0);

        final ImageView caratula=findViewById(R.id.imageViewSinopsis);
        final TextView text=findViewById(R.id.textViewSinopsis);

        final Pelicula x=this.pelix.get(posicion);
        getSupportActionBar().setTitle(x.getTitulo());
        caratula.setImageResource(x.getPortada());
        text.setText(x.getSinopsis());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        caratula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + x.idYoutube));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + x.idYoutube));
                try {
                    startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}