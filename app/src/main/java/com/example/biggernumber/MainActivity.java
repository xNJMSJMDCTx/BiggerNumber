package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button leftButton, rightButton;
    private int leftValue, rightValue;
    private int scoreValue = 0;
    TextView score;
    private int maxLives = 3;
    TextView lives;
    private Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);

        score = this.findViewById(R.id.scoreValue);
        score.setText(Integer.toString(scoreValue));

        lives = this.findViewById(R.id.livesValue);
        lives.setText(Integer.toString(maxLives));

        randomNumbers();
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(leftValue > rightValue){
                    increaseScore();
                }
                else{
                    decreaseLives();
                }
                randomNumbers();
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightValue > leftValue){
                    increaseScore();
                }
                else{
                    decreaseLives();
                }
                randomNumbers();
            }
        });
    }
    public void randomNumbers(){
        leftValue = r.nextInt(100);
        rightValue = r.nextInt(100);
        leftButton.setText(Integer.toString(leftValue));
        rightButton.setText(Integer.toString(rightValue));
    }
    public void increaseScore(){
        scoreValue++;
        score.setText(Integer.toString(scoreValue));
        Toast.makeText(getApplicationContext(),"Congratulations", Toast.LENGTH_SHORT).show();
    }
    public void decreaseLives(){
        if(maxLives > 1){
            maxLives--;
            lives.setText(Integer.toString(maxLives));
        }
        else{
            maxLives = 0;
            lives.setText(Integer.toString(maxLives));
            leftButton.setEnabled(false);
            rightButton.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Game Over", Toast.LENGTH_LONG).show();
        }
    }
}
