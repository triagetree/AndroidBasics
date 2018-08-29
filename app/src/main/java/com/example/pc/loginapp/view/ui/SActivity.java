package com.example.pc.loginapp.view.ui;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.pc.loginapp.viewmodel.api.MainApi;
import com.example.pc.loginapp.model.Movie;
import com.example.pc.loginapp.R;
import com.example.pc.loginapp.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

//import android.app.Fragment;


public class SActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //SearchView searchView;
    private List<Movie> movieList = new ArrayList<>();
   // private RecyclerView recyclerView;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private DrawerLayout mDrawerLayout;

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.nav_camera: {
                Intent intent = new Intent(getApplicationContext(), Camera.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_gallery: {
                Intent intent = new Intent(getApplicationContext(), Gallery.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_manage: {
                Intent intent = new Intent(getApplicationContext(), Tools.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_slideshow: {
                Intent intent = new Intent(getApplicationContext(), Slideshow.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_days: {
                Intent intent = new Intent(getApplicationContext(), ActivitySpinner.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_cars: {
                Intent intent = new Intent(getApplicationContext(), LIstDisplay.class);
                startActivity(intent);
                break;
            }

            case R.id.nav_images: {
                Intent intent = new Intent(getApplicationContext(), GridDisplay.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_cards: {
                Intent intent = new Intent(getApplicationContext(), RcHorizontal.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_notes: {
                Intent intent = new Intent(getApplicationContext(), Note_Activity.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_api: {
                Intent intent = new Intent(getApplicationContext(), MainApi.class);
                startActivity(intent);
                break;
            }
            case R.id.fg: {
                Intent intent = new Intent(getApplicationContext(), FrActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.Google:{
                Intent intent=new Intent(getApplicationContext(),GActivity.class);
                startActivity(intent);
                break;

        }
            case R.id.Kiki:{
                Intent intent=new Intent(getApplicationContext(),Seek.class);
                startActivity(intent);
                break;
            }
            case R.id.retro:{
                Intent intent=new Intent(getApplicationContext(),RetroResponse.class);
                startActivity(intent);
                break;
            }
        }


        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }


    private void setNavigationViewListner(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);


        SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView=(SearchView)menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mAdapter.getFilter().filter(query);
                //searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        //return true;
        //searchView.setSubmitButtonEnabled(true);
        //searchView.setOnQueryTextListener(this);

        // Configure the search info and add any event listeners...



        mDrawerLayout=findViewById(R.id.drawer_layout);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.outline_list_black_18dp);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

                case R.id.account:
                    Intent intent=new Intent(getApplicationContext(),Profil.class);
                    startActivity(intent);
                return true;
                }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        setNavigationViewListner();
        //activityMainBinding= DataBinding.Util.setContentView(this,R.layout.home;


        //searchView=(SearchView) findViewById(R.id.searchView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hi this is a Floating Action Button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mAdapter = new MyAdapter(SActivity.this, movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        prepareMovieData();
    }




    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }


}