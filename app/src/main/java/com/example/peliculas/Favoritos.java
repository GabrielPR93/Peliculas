package com.example.peliculas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    ArrayList<Pelicula> favoritos=MainActivity.peliculas;
    ArrayAdapter<Pelicula>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        setTitle("Películas Favoritas");

        final ListView lv=findViewById(R.id.ListView);
        adapter=new ArrayAdapter<Pelicula>(this,android.R.layout.simple_list_item_checked,favoritos);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        for(int i=0;i<MainActivity.peliculas.size();i++){
            lv.setItemChecked(i,favoritos.get(i).favorita);
        }
        
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(lv.isItemChecked(position)){
                favoritos.get(position).setFavorita(true);
             }else{
                 favoritos.get(position).setFavorita(false);
             }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.atras:
            onBackPressed();
            return true;
            default: return super.onOptionsItemSelected(item);
        }

    }
}
