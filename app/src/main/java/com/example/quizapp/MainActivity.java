package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int grade = 0;
    char user_allAnswer[] = new char[5];
    char[] rightAnswer = {'D', 'D', 'B', 'T', 'T'};


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
        CheckBox q4_a = (CheckBox) findViewById(R.id.q4_A);
        CheckBox q4_b = (CheckBox) findViewById(R.id.q4_B);
        CheckBox q4_c = (CheckBox) findViewById(R.id.q4_C);
        CheckBox q4_d = (CheckBox) findViewById(R.id.q4_D);
        boolean A = q4_a.isChecked();
        boolean B = q4_b.isChecked();
        boolean C = q4_c.isChecked();
        boolean D = q4_d.isChecked();
        if ((C == true && D == true) && A == false && B == false) {
            user_allAnswer[3] = 'T';
        } else {
            user_allAnswer[3] = 'F';
        }


        // get question 5 answer
        EditText q5 = (EditText) findViewById(R.id.q5);
        String answer=String.valueOf(q5.getText());
        if(answer.equals("30.7"))
        {
            user_allAnswer[4]='T';
        }
        else
        {
            user_allAnswer[4] = 'F';
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
        EditText name=(EditText)findViewById(R.id.name);
        String fullname=String.valueOf(name.getText());
        CharSequence text = "Name: "+fullname +"\n"+ "Total Scores: "+finalGrade;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}