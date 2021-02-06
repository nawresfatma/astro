package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.astro.R;

public class SecondActivity extends AppCompatActivity  {
   ImageView mainImageView;
    int images[]={R.drawable.mercury,R.drawable.venus,R.drawable.earth,R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.neptune};
    TextView Desc;
   String data2;
   int myImage;
   Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mainImageView=findViewById(R.id.Mainimgview);
        Desc=findViewById(R.id.Description);
        getData();
        setData();
        but=findViewById(R.id.button2);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),quiz.class);
                startActivity(intent );

            }});
    }


    private void getData() {
        if (getIntent().hasExtra("myImage") && getIntent().hasExtra("data2")) ;
        data2=getIntent().getStringExtra("data2");
        myImage=getIntent().getIntExtra("myImage",1);
        Toast.makeText(SecondActivity.this,String.valueOf(myImage),Toast.LENGTH_SHORT).show();
    }

    private void setData() {
     Desc.setText(data2);
   mainImageView.setImageResource(images[myImage]);

    }


}