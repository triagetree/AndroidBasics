package com.example.pc.loginapp.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.pc.loginapp.R;

public class Seek extends AppCompatActivity {

    SeekBar simpleSeekBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);

        //intitate views
       simpleSeekBar=(SeekBar) findViewById(R.id.seek);

       //perform seek bar change listener event on progress
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             progressChangedValue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Seek.this,"Seek Bar progress is : " +progressChangedValue,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
