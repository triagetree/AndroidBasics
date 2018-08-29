package com.example.pc.loginapp.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.pc.loginapp.R;

public class From extends AppCompatActivity  {

    private EditText name;
    private EditText age;

    public static final String SAVED_TEXT_KEY="SavedText";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        name=(EditText)findViewById(R.id.name);
        age=(EditText) findViewById(R.id.age);



        if(savedInstanceState!=null){
            String savedText=savedInstanceState.getString(SAVED_TEXT_KEY);
            name.setText(savedText);
            age.setText(savedText);
        }
        }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //save the state of name and age
        savedInstanceState.putString(SAVED_TEXT_KEY, name.getText().toString());
        savedInstanceState.putString(SAVED_TEXT_KEY, age.getText().toString());
    }

}
