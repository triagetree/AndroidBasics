package com.example.pc.loginapp.view.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.pc.loginapp.R;
import com.example.pc.loginapp.model.Pokemon;

import java.util.List;

public class PmAdapter extends RecyclerView.Adapter<PmAdapter.MyViewHolder> {

    private List<Pokemon> pokemons;
    private Context context;





    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, type;
        public ImageView picture;
        public RelativeLayout rl;
        public ProgressBar pg;




        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.Pokemon_name);
            type = (TextView) itemView.findViewById(R.id.Pokemon_Type);
            picture = (ImageView) itemView.findViewById(R.id.pmon);
            rl = (RelativeLayout) itemView.findViewById(R.id.rcadtest);
            pg=(ProgressBar) itemView.findViewById(R.id.homeprogress);
        }
    }

    public PmAdapter(Context context, List<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcadtest, parent, false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,int position){
        final Pokemon pokemon= pokemons.get(position);
        holder.name.setText(pokemon.getName());
        holder.type.setText(pokemon.getType());

     /* Glide.with(context)
                .load(pokemon.getPicture())
                .into(holder.picture);  */
        holder.pg.setVisibility(View.VISIBLE);
       Glide.with(context)
               .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
               .diskCacheStrategy(DiskCacheStrategy.NONE)
               .placeholder(R.drawable.hyz)
               .dontAnimate()
               .listener(new RequestListener<String, GlideDrawable>() {
                   @Override
                   public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                       holder.pg.setVisibility(View.GONE);
                       return false;
                   }

                   @Override
                   public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                   holder.pg.setVisibility(View.GONE);
                       return false;
                   }
               })
                .into(holder.picture);
        //holder.picture.setImageResource(pokemon.getPicture());

    }


    @Override
    public int getItemCount(){
        return pokemons.size();
    }
}
