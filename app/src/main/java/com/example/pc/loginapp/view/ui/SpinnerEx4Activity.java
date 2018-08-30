package com.example.pc.loginapp.view.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pc.loginapp.R;
import com.example.pc.loginapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class SpinnerEx4Activity extends Activity implements
        AdapterView.OnItemSelectedListener {
    Spinner s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnerdropdown);
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        s1.setOnItemSelectedListener(this);
        s2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub


        switch (arg0.getId()) {

            case R.id.spinner1:

                String sp1 = String.valueOf(s1.getSelectedItem());
                Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
                if (sp1.contentEquals("Income")) {
                    List<Movie> list = new ArrayList<Movie>();
                    Movie movie = new Movie();
                    movie.setTitle("XMen");
                    list.add(movie);
                    Movie movie1 = new Movie();
                    movie1.setTitle("XMen1");
                    list.add(movie1);
                    Movie movie2 = new Movie();
                    movie2.setTitle("XMen2");
                    list.add(movie2);
                    Movie movie3 = new Movie();
                    movie3.setTitle("XMen3");
                    list.add(movie3);

                    //You should add items from db here (first spinner)

                    ArrayAdapter<Movie> dataAdapter = new ArrayAdapter<Movie>(this,
                            android.R.layout.simple_spinner_item, list);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter);
                }
                if (sp1.contentEquals("Expense")) {
                    List<String> list = new ArrayList<String>();
                    list.add("Conveyance");//you should add items from db here(2nd spinner)

                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item, list);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    s2.setAdapter(dataAdapter2);
                }
                    break;


            case R.id.spinner2:

                        String sp2 = String.valueOf(s2.getSelectedItem());
                        Toast.makeText(this, sp2, Toast.LENGTH_SHORT).show();
                        break;



        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


