package com.example.astrofn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.astro.R;
import com.example.astro.ResultQuiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class quiz extends AppCompatActivity {
    private TextView countLabel;
    private TextView questionLabel;
    private Button ans1, ans2,ans3;
    private String rightAnswer;
    private int rightAnswerCount=0;
    private int quizCount=1;
    ArrayList<ArrayList<String>> quizArray= new ArrayList<>();
    String quizData[][]={
            {"Un scientifique qui étudie les astres sappelle un","astrologue","astronaute","cosmonaute"},
            {"Notre système solaire comporte","8 planetes","9 planetes","10planetes"},
            {"Quelle est la première nation à avoir envoyé un satellite dans l'espace?","les Americains","les Tunisiens","les Marrocains"},
    };

    static final private int QUIZ_COUNT=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
      countLabel=(TextView)findViewById(R.id.countLabel);
      questionLabel=(TextView)findViewById(R.id.question);
      ans1=findViewById(R.id.answer1);
        ans2=findViewById(R.id.answer2);
        ans3=findViewById(R.id.answer3);

        //quizzarray from quizzdata
        for(int i=0;i<quizData.length;i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
          //tmparray to quizzaray
            quizArray.add(tmpArray);
        }
       showNextQuiz();
    }
    public void showNextQuiz(){
        // UPDATE QUIZCOUNTLABEL
        countLabel.setText("Q"+ quizCount);
        //generate random number
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        //pick one quiz set
        ArrayList<String> quiz= quizArray.get(randomNum);
        // set quest and right answer
        questionLabel.setText(quiz.get(0));
        rightAnswer=quiz.get(1);

        // remove"question from quiz qnd shuffle choices
        quiz.remove(0);
        Collections.shuffle(quiz);

        //setChoices
        ans1.setText(quiz.get(0));
        ans2.setText(quiz.get(1));
        ans3.setText(quiz.get(2));
        //remove this quiz
        quizArray.remove(randomNum);



    }



    public void checkAnswer(View view) {
        //get pushed butt
        Button ans=(Button)findViewById(view.getId());
        String btnTxt=ans.getText().toString();

        String alertTitle;
        if(btnTxt.equals(rightAnswer)){
            alertTitle="C est Correcte !";
            rightAnswerCount++;

        }else {
            alertTitle="Oups!";
        }
        //create dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : "+ rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount==QUIZ_COUNT){
      //show result
                    Intent intent= new Intent(getApplicationContext(), ResultQuiz.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
                    startActivity(intent);
                }else{
                    quizCount++;
                  showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}