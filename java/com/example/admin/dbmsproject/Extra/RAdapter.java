package com.example.admin.dbmsproject.Extra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.dbmsproject.DBHandler;
import com.example.admin.dbmsproject.R;

/**
 * Created by Sahil Jain on 14-04-2018.
 */

public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {

    private int Type_1 = 1;
    private Context r_context;
    private int option = 1;
    private static int COUNT_EXTRA = 5;

    public RAdapter (Context context, int val){
        r_context = context;
        option = val;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v; ViewHolder vItem = null;

        if (viewType==Type_1){
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_all_options,parent,false);
            vItem = new ViewHolder(v,viewType,parent.getContext());
        }

        return vItem;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        DBHandler db = new DBHandler(r_context);

        if(option == 0){
            String[][] data = db.getAllRestaurants();

            holder.title.setText(data[0][position]);
            String temp = "Cuisine: " + data[2][position] + ", Rating: " + data[3][position];
            holder.subtitle.setText(temp);
            temp = "Rs. " + data[1][position];
            holder.cost.setText(temp);
        }
        else if(option == 1){
            String[][] data = db.getAllMovies();

            holder.title.setText(data[0][position]);
            String temp = "Genre: " + data[2][position] + ", Rating: " + data[3][position];
            holder.subtitle.setText(temp);
            temp = "Rs. " + data[1][position];
            holder.cost.setText(temp);
        }
        else if(option == 2){
            String[][] data = db.getAllTouristPlaces();

            holder.title.setText(data[0][position]);
            String temp = "Rating: " + data[2][position];
            holder.subtitle.setText(temp);
            temp = "Rs. " + data[1][position];
            holder.cost.setText(temp);
        }
        else if(option == 20){ //Trending
            String[][] data = db.getTrending();

            holder.title.setText(data[0][position]);

            String temp = new String();
            if(position < 2){
                temp = "Cuisine: " + data[2][position] + ", Rating: " + data[3][position];
            }
            else if(position < 4){
                temp = "Genre: " + data[2][position] + ", Rating: " + data[3][position];
            }
            else {
                temp = "Rating: " + data[2][position];
            }

            holder.subtitle.setText(temp);
            temp = "Rs. " + data[1][position];
            holder.cost.setText(temp);
        }
        else if(option == 21){  //Things Near Me
            String[][] data = db.getThingsNearMe();

            holder.title.setText(data[0][position]);

            String temp = new String();
            if(position < 2){
                temp = "Cuisine: " + data[2][position] + ", Rating: " + data[3][position];
            }
            else if(position < 4){
                temp = "Genre: " + data[2][position] + ", Rating: " + data[3][position];
            }
            else {
                temp = "Rating: " + data[2][position];
            }

            holder.subtitle.setText(temp);
            temp = "Rs. " + data[1][position];
            holder.cost.setText(temp);
        }
        else{
            Log.d("ABCD","Error in RAdapter");
        }

        db.close();
    }

    @Override
    public int getItemCount() {
        DBHandler db = new DBHandler(r_context);
        int count = 0;

        switch (option){
            case 0:  count = db.getRestaurantsCount(); break;
            case 1: count = db.getMoviesCount(); break;
            case 2: count = db.getTouristPlacesCount(); break;
            case 3: count = COUNT_EXTRA; break;
            case 4: count = COUNT_EXTRA; break;
            default: count = db.getRestaurantsCount(); break;
        }

        db.close();
        return count;
    }

    @Override
    public int getItemViewType (int position){
        return Type_1;
    }

    // ViewHolder Class
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, subtitle, cost;

        public ViewHolder(View itemView, int View_Type, Context context) {
            super(itemView);

            if (View_Type==Type_1){
                title = (TextView) itemView.findViewById(R.id.all_options_title);
                subtitle = (TextView) itemView.findViewById(R.id.all_options_sub_title);
                cost = (TextView) itemView.findViewById(R.id.all_options_cost);

            }//If

        }//Constructor

    }//ViewHolder Class

}//RAdapter Class
