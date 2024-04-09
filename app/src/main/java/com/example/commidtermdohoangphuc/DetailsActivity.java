package com.example.commidtermdohoangphuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView mQuestion;

    private int mQuestionNumber=0;
    private int mScore=0;
    private boolean mAnswer;
    private TextView mFinalScore;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        mFinalScore=findViewById(R.id.tv_score);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=getIntent().getExtras();
                int score=bundle.getInt("score");
                mFinalScore.setText("Score: "+score+"/10"+QuizBook.quetions.length);
                startActivity(new Intent(DetailsActivity.this,QuizActivity.class));

            }
        });





    }
}