package com.example.admin.dbmsproject.Extra;

/**
 * Created by Sahil Jain on 10-04-2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.dbmsproject.R;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    Context r_context;
    private int count = 4;

    public HomeRecyclerAdapter (Context context){
        r_context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v; ViewHolder vItem = null;

        v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_home_options,parent,false);
        vItem = new ViewHolder(v,viewType,parent.getContext());

        return vItem;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        String names[] = r_context.getResources().getStringArray(R.array.home_options);

        Integer images[] = { R.drawable.restaurants, R.drawable.cinema_hall,
                R.drawable.tourist, R.drawable.amusement_park};

        holder.setIsRecyclable(false);
        holder.textView.setText(names[position]);
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return count;
    }


    // ViewHolder Class
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView; TextView textView;

        public ViewHolder(View itemView, int View_Type, Context context) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.rec_text);
            imageView = (ImageView) itemView.findViewById(R.id.rec_icon);

        }//Constructor
    }//ViewHolder Class

}//HomeRecyclerAdapter Class
