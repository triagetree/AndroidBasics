package com.example.pc.loginapp.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.loginapp.R;
import com.example.pc.loginapp.model.Pokemon;
import com.example.pc.loginapp.view.adapter.MyAdapter;
import com.example.pc.loginapp.view.adapter.PmAdapter;

import java.util.ArrayList;
import java.util.List;

public class PkmnActivity extends AppCompatActivity {

    private List<Pokemon> pokemons=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private PmAdapter pmAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rctest);


        mRecyclerView=(RecyclerView) findViewById(R.id.rcview2);
        pmAdapter=new PmAdapter(PkmnActivity.this,pokemons);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(pmAdapter);


        preparePokemonData();


    }
    private void preparePokemonData(){
        Pokemon pokemon=new Pokemon("Pikachu","Electric",R.drawable.electric);
        pokemons.add(pokemon);

        pokemon=new Pokemon("Squirtel","Water",R.drawable.water);
        pokemons.add(pokemon);

        pokemon=new Pokemon("Bulbasaur","Grass",R.drawable.grass);
        pokemons.add(pokemon);
        pokemon=new Pokemon("Charmander","Fire",R.drawable.fire);
        pokemons.add(pokemon);
        pokemon=new Pokemon("Pidgeotoo","Air",R.drawable.air);
        pokemons.add(pokemon);
        pokemon=new Pokemon("Staryu","Water",R.drawable.water);
        pokemons.add(pokemon);
        pokemon=new Pokemon("Krabby","Water",R.drawable.water);
        pokemons.add(pokemon);
        pokemon=new Pokemon("Snorlax","Land",R.drawable.land);
        pokemons.add(pokemon);



        pmAdapter.notifyDataSetChanged();
    }


}
