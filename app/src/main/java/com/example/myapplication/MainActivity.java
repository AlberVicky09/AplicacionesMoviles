package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Quiz list creation
    String [][] questAnsw = new String[10][5];

    //Correct answers list
    int [] correctAns = new int[10];

    //Question Text
    TextView questText;

    //Answer Texts
    RadioButton ansBut1;
    RadioButton ansBut2;
    RadioButton ansBut3;
    RadioButton ansBut4;

    //Answer block
    RadioGroup ansGroup;

    //Answer texts
    TextView pointTxt;
    TextView corrTxt;
    TextView wrngTxt;

    //Variables
    int num;
    int answered;
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fill questions
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 5; j++){
                if(j == 0)
                    questAnsw[i][j] = "Question " + i;
                else
                    questAnsw[i][j] = "Answer " + j;
            }
        }

        //Fill correct questions
        correctAns[0] = 0;
        correctAns[1] = 1;
        correctAns[2] = 2;
        correctAns[3] = 3;
        correctAns[4] = 0;
        correctAns[5] = 1;
        correctAns[6] = 2;
        correctAns[7] = 3;
        correctAns[8] = 0;
        correctAns[9] = 1;

        //Find screen objects
        questText = findViewById(R.id.questionText);
        ansBut1 = findViewById(R.id.rdBtn1);
        ansBut2 = findViewById(R.id.rdBtn2);
        ansBut3 = findViewById(R.id.rdBtn3);
        ansBut4 = findViewById(R.id.rdBtn4);
        ansGroup = findViewById(R.id.rdbGp);
        pointTxt = findViewById(R.id.pointTxt);
        corrTxt = findViewById(R.id.corrAnsTxt);
        wrngTxt = findViewById(R.id.wrongAnsTxt);

        //Initialize variables
        num = 0;
        points = 0;

        UpdateQuestions(num);

        //Control answer clicked
        ansBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answered = 0;
            }
        });
        ansBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answered = 1;
            }
        });
        ansBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answered = 2;
            }
        });
        ansBut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answered = 3;
            }
        });
        //Skip button
        Button contBut = findViewById(R.id.contBut);
        contBut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //If bool is active, answer has been pressed
                if(ansGroup.getCheckedRadioButtonId() != -1){
                    CheckAnswer(num, answered);
                    num++;
                    //If not all questions are answered, update them
                    if(num < 10){
                        UpdateQuestions(num);
                    }else {
                        //If all questions are answered, go to score
                        Intent i = new Intent(MainActivity.this, ScoreActivity.class);
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void UpdateQuestions(int num){
        answered = -1;
        questText.setText(questAnsw[num][0]);
        ansGroup.clearCheck();
        ansBut1.setText(questAnsw[num][1]);
        ansBut2.setText(questAnsw[num][2]);
        ansBut3.setText(questAnsw[num][3]);
        ansBut4.setText(questAnsw[num][4]);
    }

    public void CheckAnswer(int num, int answered){

        final Handler handler = new Handler(Looper.getMainLooper());
        //corrTxt.setVisibility(View.VISIBLE);

        //Answered correctly
        if(answered == correctAns[num]){

            //Add points
            points += 1;
            //Update points
            pointTxt.setText("Puntuación: " + points);
            //Show correct text
            corrTxt.setVisibility(View.VISIBLE);

        }else{

            //Show wrong text
            wrngTxt.setVisibility(View.VISIBLE);
            //Mark wrong answer in red
            switch(answered){
                case 0:
                    ansBut1.setBackgroundColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansBut1.setBackgroundColor(getResources().getColor(R.color.white));
                        }
                    }, 1000);
                break;

                case 1:
                    ansBut2.setBackgroundColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansBut2.setBackgroundColor(getResources().getColor(R.color.white));
                        }
                    }, 1000);
                break;

                case 2:
                    ansBut3.setBackgroundColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansBut3.setBackgroundColor(getResources().getColor(R.color.white));
                        }
                    }, 1000);
                break;

                case 3:
                    ansBut4.setBackgroundColor(getResources().getColor(R.color.red));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ansBut4.setBackgroundColor(getResources().getColor(R.color.white));
                        }
                    }, 1000);
                break;
            }
        }

        //Tint correct answer in green
        switch(correctAns[num]){
            case 0:
                ansBut1.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ansBut1.setBackgroundColor(getResources().getColor(R.color.white));
                        //Hide texts
                        corrTxt.setVisibility(View.INVISIBLE);
                        wrngTxt.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            break;

            case 1:
                ansBut2.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ansBut2.setBackgroundColor(getResources().getColor(R.color.white));
                        //Hide texts
                        corrTxt.setVisibility(View.INVISIBLE);
                        wrngTxt.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            break;

            case 2:
                ansBut3.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ansBut3.setBackgroundColor(getResources().getColor(R.color.white));
                        //Hide texts
                        corrTxt.setVisibility(View.INVISIBLE);
                        wrngTxt.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            break;

            case 3:
                ansBut4.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ansBut4.setBackgroundColor(getResources().getColor(R.color.white));
                        //Hide texts
                        corrTxt.setVisibility(View.INVISIBLE);
                        wrngTxt.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            break;
        }

        answered = -1;
    }
}