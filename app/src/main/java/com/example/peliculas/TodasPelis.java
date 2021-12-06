package com.example.peliculas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class TodasPelis extends AppCompatActivity {
    ArrayList<Pelicula>todas;
    static RecyclerView rv2;
    RecyclerView.LayoutManager miLayoutManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todaspelis);
        setTitle("Listado Completo");



        todas=MainActivity.peliculas;

       final MiAdaptador2 miAdaptador2=new MiAdaptador2(todas);
        rv2=findViewById(R.id.reciclerView2);
        miLayoutManager2=new LinearLayoutManager(this);

        rv2.setLayoutManager(miLayoutManager2);
        rv2.setAdapter(miAdaptador2);

        miAdaptador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TodasPelis.this,Sinopsis.class);
                intent.putExtra("posicion",rv2.getChildAdapterPosition(v));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menuatras,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAtras:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
