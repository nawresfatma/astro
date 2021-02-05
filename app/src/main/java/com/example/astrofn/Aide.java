package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.astro.R;
import com.example.astrofn.listePlanet;
//commentaire
public class Aide extends AppCompatActivity {
   ImageView ast ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aide);
ast=findViewById(R.id.imageView14);
        ast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), listePlanet.class);
                startActivity(intent );

            }});

    }
}