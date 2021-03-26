package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int grade = 0;
    char user_allAnswer[] = new char[5];
    char[] rightAnswer = {'D', 'D', 'B', 'A', 'A'};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        // get question 1 answer
        RadioGroup q1 = (RadioGroup) findViewById(R.id.question1);
        RadioButton q1_check = (RadioButton) findViewById(q1.getCheckedRadioButtonId());
        if (q1.getCheckedRadioButtonId() == -1) {
            user_allAnswer[0] = 'X';
        } else {
            char q1_userAnswer = q1_check.getText().charAt(1);
            user_allAnswer[0] = q1_userAnswer;
        }

        // get question 2 answer
        RadioGroup q2 = (RadioGroup) findViewById(R.id.question2);
        RadioButton q2_check = (RadioButton) findViewById(q2.getCheckedRadioButtonId());
        if (q2.getCheckedRadioButtonId() == -1) {
            user_allAnswer[1] = 'X';
        } else {
            char q2_userAnswer = q2_check.getText().charAt(1);
            user_allAnswer[1] = q2_userAnswer;
        }

        // get question 3 answer
        RadioGroup q3 = (RadioGroup) findViewById(R.id.question3);
        RadioButton q3_check = (RadioButton) findViewById(q3.getCheckedRadioButtonId());
        if (q3.getCheckedRadioButtonId() == -1) {
            user_allAnswer[2] = 'X';
        } else {
            char q3_userAnswer = q3_check.getText().charAt(1);
            user_allAnswer[2] = q3_userAnswer;
        }


        // get question 4 answer
        RadioGroup q4 = (RadioGroup) findViewById(R.id.question4);
        RadioButton q4_check = (RadioButton) findViewById(q4.getCheckedRadioButtonId());
        if (q4.getCheckedRadioButtonId() == -1) {
            user_allAnswer[3] = 'X';
        } else {
            char q4_userAnswer = q4_check.getText().charAt(1);
            user_allAnswer[3] = q4_userAnswer;

        }

        // get question 5 answer
        RadioGroup q5 = (RadioGroup) findViewById(R.id.question5);
        RadioButton q5_check = (RadioButton) findViewById(q5.getCheckedRadioButtonId());
        if (q5.getCheckedRadioButtonId() == -1) {
            user_allAnswer[4] = 'X';
        } else {
            char q5_userAnswer = q5_check.getText().charAt(1);
            user_allAnswer[4] = q5_userAnswer;
        }
    }

    public void submitGrade(View view) {
        onRadioButtonClicked(view);
        int numberOfQestion = rightAnswer.length;
        int counter =0;
        while(counter!=5)
        {
            char user=user_allAnswer[counter];
            char right=rightAnswer[counter];
            if(String.valueOf(user).equals(String.valueOf(right)))
            {
                grade+=1;
            }
            counter++;
        }
        int finalGrade=grade;
        grade=0;
        Context context = getApplicationContext();
        CharSequence text = "Total Scores: "+finalGrade;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}