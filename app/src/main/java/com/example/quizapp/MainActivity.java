package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView optionA,optionB,optionC,optionD;
    private TextView questionNumber,question,score;
    private TextView checkOut1,checkOut2;
    int currentIndex;
    int msScore=0;
    int qn=1;
    ProgressBar progressBar;

    int currentQuestion,currentOptionA,currentOptionB,currentOptionC,currentOptionD;

    AnswerClass[] questionBank=new AnswerClass[]
            {
                    new AnswerClass(R.string.question_1,R.string.optionA,R.string.optionB,R.string.optionC,R.string.optionD,R.string.answerQus_1),
                    new AnswerClass(R.string.question_2,R.string.option2A,R.string.option2B,R.string.option2C,R.string.option2D,R.string.answerQus_2),
                    new AnswerClass(R.string.question_3,R.string.option3A,R.string.option3B,R.string.option3C,R.string.option3D,R.string.answerQus_3),
                    new AnswerClass(R.string.question_4,R.string.option4A,R.string.option4B,R.string.option4C,R.string.option4D,R.string.answerQus_4),
                    new AnswerClass(R.string.question_5,R.string.option5A,R.string.option5B,R.string.option5C,R.string.option5D,R.string.answerQus_5),
                    new AnswerClass(R.string.question_6,R.string.option6A,R.string.option6B,R.string.option6C,R.string.option6D,R.string.answerQus_6),
                    new AnswerClass(R.string.question_7,R.string.option7A,R.string.option7B,R.string.option7C,R.string.option7D,R.string.answerQus_7),
                    new AnswerClass(R.string.question_8,R.string.option8A,R.string.option8B,R.string.option8C,R.string.option8D,R.string.answerQus_8),
                    new AnswerClass(R.string.question_9,R.string.option9A,R.string.option9B,R.string.option9C,R.string.option9D,R.string.answerQus_9),
                    new AnswerClass(R.string.question_10,R.string.option10A,R.string.option10B,R.string.option10C,R.string.option10D,R.string.answerQus_10)

            };
    final int PROGRESS_BAR= (int) Math.ceil(100/questionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        question=findViewById(R.id.question);
        score=findViewById(R.id.score);
        questionNumber=findViewById(R.id.questionNumber);

        checkOut1=findViewById(R.id.selectedOption);
        checkOut2=findViewById(R.id.correctAnswer);
        progressBar=findViewById(R.id.progressBar);

        currentQuestion=questionBank[currentIndex].getQuestionID();
        question.setText(currentQuestion);

        currentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);

        currentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);

        currentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);

        currentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);


        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionA);
                updateQuestion();

            }
        });


        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionB);
                updateQuestion();

            }
        });


        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionC);
                updateQuestion();
            }
        });


        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionD);
                updateQuestion();

            }
        });


    }

    private void checkAnswer(int userSelection) {

        int correctAnswer=questionBank[currentIndex].getAnswerID();

        checkOut1.setText(userSelection);
        checkOut2.setText(correctAnswer);

        String m=checkOut1.getText().toString().trim();
        String n=checkOut2.getText().toString().trim();

        if (m.equals(n)){
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            msScore+=1;
        }
        else {
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion() {
        currentIndex=(currentIndex+1)%questionBank.length;

        if (currentIndex==0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score " + msScore + " Points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    msScore = 0;
                    qn = 1;
                    progressBar.setProgress(0);
                    score.setText("Score " + msScore + "/" + questionBank.length);
                    questionNumber.setText(qn + "/" + questionBank.length + " Question");
                }
            });
            alert.show();
        }


        currentQuestion=questionBank[currentIndex].getQuestionID();
        question.setText(currentQuestion);

        currentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);

        currentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);

        currentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);

        currentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);

        qn=qn+1;

        if (qn<=questionBank.length){
            questionNumber.setText(qn+"/"+questionBank.length+" Question");
        }
        score.setText("Score "+msScore+"/"+questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);

    }
}