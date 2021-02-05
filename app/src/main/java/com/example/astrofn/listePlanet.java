package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.astro.R;

public class listePlanet extends AppCompatActivity {
    RecyclerView  recycler;
    String s1[] , s2[];
    int images[]={R.drawable.mercury,R.drawable.venus,R.drawable.earth,R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.neptune};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_planet);
        recycler=findViewById(R.id.recycler);

        s1=getResources().getStringArray(R.array.Liste_des_planetes);
        s2=getResources().getStringArray(R.array.informations);

        MyAdapter myAdapter=new MyAdapter(this,s1,s2,images);
        recycler.setAdapter(myAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}