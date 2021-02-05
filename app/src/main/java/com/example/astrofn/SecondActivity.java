package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.astro.R;

public class SecondActivity extends AppCompatActivity {
   ImageView mainImageView;
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
        myImage=getIntent().getIntExtra("myImage,",1);

    }

    private void setData() {
     Desc.setText(data2);
     mainImageView.setImageResource(myImage);

    }
}