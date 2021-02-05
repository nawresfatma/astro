package com.example.astrofn;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.astro.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
 String data1[],data2[];
 int images[];
 Context context;
  public MyAdapter(Context ct , String s1[],String s2[],int img[]){
    context=ct;
    data1=s1;
    data2=s2;
    images=img;
  }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
      holder.myText.setText(data1[position]);
     holder.myText2.setText(data2[position]);
     holder.myImage.setImageResource(images[position]);
     holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),SecondActivity.class);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("myImage",position);
                v.getContext().startActivity(intent);
            }
        });

    }

    private Context getContext() {
      return context;
    }


    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
      TextView myText,myText2;
      ImageView myImage;
      ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myText=itemView.findViewById(R.id.Listeplanete);
            myText2=itemView.findViewById(R.id.informations);
            myImage=itemView.findViewById(R.id.planete);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
