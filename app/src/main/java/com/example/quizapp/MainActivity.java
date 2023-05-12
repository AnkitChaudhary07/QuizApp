package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String questions[] = {"Android development is only done in JAVA?","XML is used for layout and designing in AD?","Java is 100% OOPS?","Kotlin is used in Android Development?","Flutter cannot be used in ios"};
    boolean ans[] = {false,true,false,true,false};
    Button correct;
    Button incorrect;
    TextView textView, result;
    private int index = 0;
    private int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correct = findViewById(R.id.correct);
        incorrect = findViewById(R.id.incorrect);
        textView = findViewById(R.id.textView);
        result = findViewById(R.id.result);
        textView.setText(questions[index]);

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    // if Questions are left...
                    if (ans[index] == true) {
                        score++;
                    }
                    /** Go to the next Question **/
                    index++;
                    if (index <= questions.length - 1) {
                        textView.setText(questions[index]);
                    } else {
                        result.setText("Total marks: "+questions.length+"\n" + "Your score is: " + score);
                    }
                }
                else
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
            }
        });

        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if Questions are left...
                if (index <= questions.length - 1) {
                    if (ans[index] == false) {
                        score++;
                    }
                    /** Go to the next Question **/
                    index++;
                    if (index <= questions.length - 1) {
                        textView.setText(questions[index]);
                    } else {
                        result.setText("Total marks: 5\n"+"Your score is: " + score);
                    }
                }
                else
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}