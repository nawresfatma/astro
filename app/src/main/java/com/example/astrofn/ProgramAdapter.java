package com.example.astrofn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;
    String[] planets;
    String[] descriptions;
    int[] images;

    public ProgramAdapter(MainActivity context, String[] planets, String[] descriptions, int[] images) {
        this.context = context;
        this.planets=planets;
        this.descriptions=descriptions;
        this.images=images;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            rowName = itemView.findViewById(R.id.title);
            rowDescription = itemView.findViewById(R.id.description);
            rowImage =itemView.findViewById(R.id.imageView);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.planet,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowName.setText(planets[position]);
        holder.rowDescription.setText(descriptions[position]);
        holder.rowImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return planets.length;
    }
}

