package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.astro.R;
//commentaire
public class listePlanet extends AppCompatActivity {
    RecyclerView  recycler;
    TextView listeplanet;
    String s1[] , s2[];
    int images[]={R.drawable.mercury,R.drawable.venus,R.drawable.earth,R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.neptune};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_planet);
        recycler=findViewById(R.id.recycler);
        listeplanet=findViewById(R.id.Listeplanete);

        s1=getResources().getStringArray(R.array.Liste_des_planetes);
        s2=getResources().getStringArray(R.array.informations);

        MyAdapter myAdapter=new MyAdapter(this,s1,s2,images);
        recycler.setAdapter(myAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //Typeface Astro=Typeface.createFromAsset(getAssets(),"font/melanie.ttf");
        //listeplanet.setTypeface(Astro);

    }
}