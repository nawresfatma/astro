package com.example.astro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Set;

public class ResultQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        TextView resultaLabel=findViewById(R.id.resultat);
        TextView totalScore=findViewById(R.id.total);
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);
        SharedPreferences settings=getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore1=settings.getInt("totalScore",0);
        totalScore1+=score;



        resultaLabel.setText(score+" / 3");
        totalScore.setText("le Score Totale est : "+totalScore1);

        //update tot score
        SharedPreferences.Editor editor= settings.edit();
        editor.putInt("le score totale est :" , totalScore1);
        editor.commit();

    }
}