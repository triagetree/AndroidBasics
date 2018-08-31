package com.example.pc.loginapp.view.ui;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.pc.loginapp.R;

public class BottomNavigation extends AppCompatActivity {

    private ActionBar toolbar;

    @Override

    public void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.nvcrd);

        toolbar=getSupportActionBar();




        BottomNavigationView navigation=(BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle("Profile");
        loadFragment(new Pfragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener(){


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Pfragment fragment;



                    switch (item.getItemId()){
                        case R.id.navigation_shop:
                            toolbar.setTitle("Profile");
                            fragment =new Pfragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_gifts:
                            toolbar.setTitle("Mesages");
                            fragment =new Pfragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_cart:
                            toolbar.setTitle("Notifications");
                            fragment =new Pfragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_profile:
                            toolbar.setTitle("Notes");
                            fragment =new Pfragment();
                            loadFragment(fragment);
                            return true;
        }
        return false;
    }
    };

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
