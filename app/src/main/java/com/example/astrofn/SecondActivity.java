package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.astro.R;
//commentaire
public class SecondActivity extends AppCompatActivity  {
   ImageView mainImageView;
    int images[]={R.drawable.mercury,R.drawable.venus,R.drawable.earth,R.drawable.mars,R.drawable.jupiter,R.drawable.saturn,R.drawable.uranus,R.drawable.neptune};
    TextView Desc;
   String data2;
   int myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView=findViewById(R.id.Mainimgview);
        Desc=findViewById(R.id.Description);
        getData();
        setData();


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