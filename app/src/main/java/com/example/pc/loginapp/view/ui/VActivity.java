package com.example.pc.loginapp.view.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.pc.loginapp.R;

/**
 * Created by Pc on 02-08-2018.
 */

public class VActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){

            switch (item.getItemId()) {
                case android.R.id.home:
                    finish();
                    break;

            }
            return super.onOptionsItemSelected(item);

    }
}
