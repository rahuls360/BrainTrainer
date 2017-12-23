package com.rahulmakhija.braintrainer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView, timerTextView, scoreTextView;
    Button button1, button2, button3, button4;
    ArrayList<String> answerOptions;
    int correctTag, scoreCorrect, scoreTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        timerTextView = findViewById(R.id.timerTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        Random random = new Random();
        int a = random.nextInt(21); Log.i("a",Integer.toString(a));
        int b = random.nextInt(21); Log.i("b",Integer.toString(b));
        questionTextView.setText(a + "+" + b);

        int correctAnswer = a+b; Log.i("correctAnswer",Integer.toString(correctAnswer));
        correctTag = random.nextInt(4); Log.i("correctTag",Integer.toString(correctTag));

        answerOptions = new ArrayList<String>();

        for (int i=0;i<4;i++){
            if (i == correctTag){
                answerOptions.add(Integer.toString(correctAnswer));
            }
            else{
                int incorrectAnswer = random.nextInt(41); Log.i("RandomNumber1", Integer.toString(incorrectAnswer));
                while (incorrectAnswer == correctAnswer){
                    incorrectAnswer = random.nextInt(41); Log.i("RandomNumber2", Integer.toString(incorrectAnswer));
                }
                answerOptions.add(Integer.toString(incorrectAnswer));
            }
        }
        Log.i("ArrayList", answerOptions.toString());
        button1.setText(answerOptions.get(0));
        button2.setText(answerOptions.get(1));
        button3.setText(answerOptions.get(2));
        button4.setText(answerOptions.get(3));



    }






    public void answerSelected(View view){
        String x = String.valueOf(view.getTag());
        if (correctTag == Integer.valueOf(x)) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            scoreCorrect++;
            scoreTotal++;
        }
        else{
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
            scoreTotal++;
        }
        scoreTextView.setText(scoreCorrect+ "/" + scoreTotal );
    }
}
