package com.example.pc.loginapp.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Pc on 04-08-2018.
 */


import android.view.View;

import com.example.pc.loginapp.model.Movie;
import com.example.pc.loginapp.view.ui.Camera;
import com.example.pc.loginapp.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    private List<Movie> moviesList;
    private List<Movie> contactListFiltered;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, year, genre;
        public RelativeLayout rl_click;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            rl_click = (RelativeLayout) view.findViewById(R.id.rl_click);
        }
    }

    public MyAdapter(Context context, List<Movie> moviesList) {
        this.moviesList = moviesList;
        contactListFiltered=moviesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Movie movie = contactListFiltered.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.rl_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i = new Intent(context, Camera.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    contactListFiltered = moviesList;
                } else {
                    List<Movie> filteredList = new ArrayList<>();
                    for (Movie row : contactListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    contactListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = contactListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
             contactListFiltered=(ArrayList<Movie>) filterResults.values;
             notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount () {
        return contactListFiltered.size();
    }
}



