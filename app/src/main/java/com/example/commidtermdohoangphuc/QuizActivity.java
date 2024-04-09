package com.example.commidtermdohoangphuc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestion;
    private Button btnTrue,btnFalse,btnNext,btnBack;
    private int mQuestionNumber=0;
    private int mScore=0;
    private boolean mAnswer;
    private TextView mScorerView;
    MainActivity mainActivity;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestion=findViewById(R.id.tv_quiz);
        btnTrue=findViewById(R.id.btn_true);
        btnFalse=findViewById(R.id.btn_false);
        btnNext=findViewById(R.id.btn_next);
        btnBack=findViewById(R.id.btn_back);
        mScorerView=findViewById(R.id.tv_score);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                btnNext.setBackgroundColor(Color.BLUE);

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backQuestion();
                btnBack.setBackgroundColor(Color.YELLOW);

            }
        });
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTrue.setBackgroundColor(Color.YELLOW);
                if(mAnswer==true){
                    mScore++;
                    updateScore(mScore);
                    if(mQuestionNumber==QuizBook.quetions.length){
                        Intent i =new Intent(QuizActivity.this,DetailsActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);



                    }else{
                        updateQuestion();
                    }


                }
                else {
                    if(mQuestionNumber==QuizBook.quetions.length){
                        Intent i =new Intent(QuizActivity.this,DetailsActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);



                    }else{
                        updateQuestion();
                    }

                }

            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFalse.setBackgroundColor(Color.BLUE);
                if(mAnswer==false){
                    mScore++;
                    updateScore(mScore);
                    if(mQuestionNumber==QuizBook.quetions.length){
                        Intent i =new Intent(QuizActivity.this,DetailsActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",mScore);
                        i.putExtras(bundle);

                        startActivity(i);



                    }else{
                        updateQuestion();
                    }


                }
                else {
                    if(mQuestionNumber==QuizBook.quetions.length){
                        Intent i =new Intent(QuizActivity.this,DetailsActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",mScore);
                        i.putExtras(bundle);

                        startActivity(i);



                    }else{
                        updateQuestion();
                    }

                }

            }
        });
    }

    private void updateQuestion(){
        mQuestion.setText(QuizBook.quetions[mQuestionNumber]);
        mAnswer=QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }
    public void updateScore(int point){
        mScorerView.setText(""+mScore);

    }
    private void backQuestion(){
        mQuestion.setText(QuizBook.quetions[mQuestionNumber]);
        mAnswer=QuizBook.answers[mQuestionNumber];
        mQuestionNumber--;
    }
}