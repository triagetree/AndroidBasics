package com.example.pc.loginapp.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.pc.loginapp.R;

public class From extends AppCompatActivity  {

    private EditText name;
    private EditText age;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        name=(EditText)findViewById(R.id.name);
        age=(EditText) findViewById(R.id.age);
        }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("name", name.getText().toString());
        savedInstanceState.putString("age", age.getText().toString());
    }
        @Override
        public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String nm=savedInstanceState.getString("name");
        String ag=savedInstanceState.getString("age");
        }


}