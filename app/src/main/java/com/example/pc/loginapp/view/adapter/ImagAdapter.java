package com.example.pc.loginapp.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.pc.loginapp.R;

/**
 * Created by Pc on 06-08-2018.
 */

public class ImagAdapter extends BaseAdapter {

    private Context mContext;

    // Constructor
    public ImagAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.baseline_account_circle_black_18dp, R.drawable.baseline_check_circle_black_18dp,
            R.drawable.baseline_games_black_18dp, R.drawable.outline_list_black_18dp,
            R.drawable.back2, R.drawable.fabb,R.drawable.splash,
            R.drawable.fab,R.drawable.best,R.drawable.bird,
            R.drawable.flow,R.drawable.ic_launcher_background

    };
}
