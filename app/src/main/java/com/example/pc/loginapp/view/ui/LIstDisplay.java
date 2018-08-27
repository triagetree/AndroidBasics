package com.example.pc.loginapp.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pc.loginapp.R;

import java.util.ListIterator;

/**
 * Created by Pc on 06-08-2018.
 */

public class LIstDisplay extends AppCompatActivity {


    String[] Cars={"Audi","Mercedes","BMW","Ferrari","Lamborghini","Rolls-Royce","Bugatti Veyron","Aston Martin"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listshow);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,Cars);

        ListView listView=(ListView)findViewById(R.id.car_list);
        listView.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}




