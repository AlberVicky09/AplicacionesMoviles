package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Quiz list creation
    String [][] questAnsw = new String[10][5];
    //Image list creation
    int [] questImgArray = new int[3];

    //Correct answers list
    int [] correctAns = new int[10];

    //Question Text
    TextView questText;
    TextView questImgText;
    ImageView questImg;

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
    String name;
    int num;
    int answered;
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get name from intent
        Bundle bundle = this.getIntent().getExtras();
        name = bundle.getString("Nombre");

        //Fill questions
        questAnsw[0][0] = "";        questAnsw[0][1] = "";        questAnsw[0][2] = "";        questAnsw[0][3] = "";        questAnsw[0][4] = "";
        questAnsw[1][0] = "";        questAnsw[1][1] = "";        questAnsw[1][2] = "";        questAnsw[1][3] = "";        questAnsw[1][4] = "";
        questAnsw[2][0] = "";        questAnsw[2][1] = "";        questAnsw[2][2] = "";        questAnsw[2][3] = "";        questAnsw[2][4] = "";
        questAnsw[3][0] = "";        questAnsw[3][1] = "";        questAnsw[3][2] = "";        questAnsw[3][3] = "";        questAnsw[3][4] = "";
        questAnsw[4][0] = "";        questAnsw[4][1] = "";        questAnsw[4][2] = "";        questAnsw[4][3] = "";        questAnsw[4][4] = "";
        questAnsw[5][0] = "";        questAnsw[5][1] = "";        questAnsw[5][2] = "";        questAnsw[5][3] = "";        questAnsw[5][4] = "";
        questAnsw[6][0] = "";        questAnsw[6][1] = "";        questAnsw[6][2] = "";        questAnsw[6][3] = "";        questAnsw[6][4] = "";
        questAnsw[7][0] = "";        questAnsw[7][1] = "";        questAnsw[7][2] = "";        questAnsw[7][3] = "";        questAnsw[7][4] = "";
        questAnsw[8][0] = "";        questAnsw[8][1] = "";        questAnsw[8][2] = "";        questAnsw[8][3] = "";        questAnsw[8][4] = "";
        questAnsw[9][0] = "";        questAnsw[9][1] = "";        questAnsw[9][2] = "";        questAnsw[9][3] = "";        questAnsw[9][4] = "";


        //Fill image questions
        questImgArray[0] = R.drawable.wind_waker_flag;
        questImgArray[1] = R.drawable.mario_bros;
        questImgArray[2] = R.drawable.destello;

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
        questImgText = findViewById(R.id.imgQstntxt);
        questImg = findViewById(R.id.imgQstn);
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
        ansBut1.setOnClickListener(view -> answered = 0);
        ansBut2.setOnClickListener(view -> answered = 1);
        ansBut3.setOnClickListener(view -> answered = 2);
        ansBut4.setOnClickListener(view -> answered = 3);

        //Skip button
        Button contBut = findViewById(R.id.contBut);
        contBut.setOnClickListener(v -> {
            //If bool is active, answer has been pressed
            if(ansGroup.getCheckedRadioButtonId() != -1){
                CheckAnswer(num, answered);
                num++;
                //If not all questions are answered, update them
                if(num < 10){
                    UpdateQuestions(num);
                }else {
                    //If all questions are answered, go to score
                    Intent punt = new Intent(MainActivity.this, Results.class);
                    punt.putExtra("Nombre", name);
                    punt.putExtra("Puntuacion", points);
                    startActivity(punt);
                }
            }
        });
    }

    public void UpdateQuestions(int num){
        answered = -1;
        if(num < 7){
            //Text questions
            questText.setVisibility(View.VISIBLE);
            questText.setText(questAnsw[num][0]);

            questImg.setVisibility(View.INVISIBLE);
            questImgText.setVisibility(View.INVISIBLE);

        }else{
            //Image questions
            questText.setVisibility(View.INVISIBLE);

            questImg.setVisibility(View.VISIBLE);
            questImgText.setVisibility(View.VISIBLE);

            questImg.setImageResource(questImgArray[num-7]);
            questImgText.setText(questAnsw[num][0]);
        }
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
                    handler.postDelayed(() -> ansBut1.setBackgroundColor(getResources().getColor(R.color.white)), 1000);
                break;

                case 1:
                    ansBut2.setBackgroundColor(getResources().getColor(R.color.red));
                    handler.postDelayed(() -> ansBut2.setBackgroundColor(getResources().getColor(R.color.white)), 1000);
                break;

                case 2:
                    ansBut3.setBackgroundColor(getResources().getColor(R.color.red));
                    handler.postDelayed(() -> ansBut3.setBackgroundColor(getResources().getColor(R.color.white)), 1000);
                break;

                case 3:
                    ansBut4.setBackgroundColor(getResources().getColor(R.color.red));
                    handler.postDelayed(() -> ansBut4.setBackgroundColor(getResources().getColor(R.color.white)), 1000);
                break;
            }
        }

        //Tint correct answer in green
        switch(correctAns[num]){
            case 0:
                ansBut1.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(() -> {
                    ansBut1.setBackgroundColor(getResources().getColor(R.color.white));
                    //Hide texts
                    corrTxt.setVisibility(View.INVISIBLE);
                    wrngTxt.setVisibility(View.INVISIBLE);
                }, 1000);
            break;

            case 1:
                ansBut2.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(() -> {
                    ansBut2.setBackgroundColor(getResources().getColor(R.color.white));
                    //Hide texts
                    corrTxt.setVisibility(View.INVISIBLE);
                    wrngTxt.setVisibility(View.INVISIBLE);
                }, 1000);
            break;

            case 2:
                ansBut3.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(() -> {
                    ansBut3.setBackgroundColor(getResources().getColor(R.color.white));
                    //Hide texts
                    corrTxt.setVisibility(View.INVISIBLE);
                    wrngTxt.setVisibility(View.INVISIBLE);
                }, 1000);
            break;

            case 3:
                ansBut4.setBackgroundColor(getResources().getColor(R.color.green));
                handler.postDelayed(() -> {
                    ansBut4.setBackgroundColor(getResources().getColor(R.color.white));
                    //Hide texts
                    corrTxt.setVisibility(View.INVISIBLE);
                    wrngTxt.setVisibility(View.INVISIBLE);
                }, 1000);
            break;
        }

        //answered = -1;
    }

}