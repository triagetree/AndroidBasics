package com.example.pc.loginapp.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.pc.loginapp.R;
import com.example.pc.loginapp.view.adapter.ImagAdapter;

/**
 * Created by Pc on 06-08-2018.
 */

public class GridDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_show);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gridview=(GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImagAdapter(this));
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

