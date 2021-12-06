package com.example.peliculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Anhadir extends AppCompatActivity {
	//Añadir
	//Añadir
    boolean muestra=false;
    public String seleccionSala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anhadir);
        final TextView nombre=findViewById(R.id.textAñadirTitulo);
        final TextView director=findViewById(R.id.textAñadirDirector);
        final TextView duracion=findViewById(R.id.textAñadirDuracion);
        final Spinner sala=findViewById(R.id.spinner);
        final RadioGroup edad=findViewById(R.id.radioGroup);
        final DatePicker fecha=findViewById(R.id.datepicker);
        final String[]salas=getResources().getStringArray(R.array.salas);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        setTitle("Nueva Película");
        


        final Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        final DatePicker dp=(DatePicker)findViewById(R.id.datepicker);
        dp.setFirstDayOfWeek(1);



        final ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,salas);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!muestra)muestra=true;
                else{
                    seleccionSala=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.atras:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}