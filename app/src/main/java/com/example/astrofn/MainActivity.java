package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.astro.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;
    String[] planets = {"Earth","Mars","Neptune","Uranus","Mercury","Saturn","Jupiter"};
    String[] descriptions = {"Earth desc","Mars desc","Neptune desc","Uranus desc","Mercury desc","Saturn desc","Jupiter desc"};
    int[] images ={R.drawable.earth , R.drawable.mars,R.drawable.neptune,R.drawable.uranus,R.drawable.mercury , R.drawable.saturn,R.drawable.jupiter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        programAdapter = new ProgramAdapter(this,planets,descriptions,images);
        recyclerView.setAdapter(programAdapter);



    }
}