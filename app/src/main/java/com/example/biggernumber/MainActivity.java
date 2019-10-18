package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button leftButton, rightButton;
    private int leftValue, rightValue;
    private Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);

        randomNumbers();
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(leftValue > rightValue){
                    Toast.makeText(getApplicationContext(),"Congratulations", Toast.LENGTH_SHORT).show();
                }
                randomNumbers();
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightValue > leftValue){
                    Toast.makeText(getApplicationContext(),"Congratulations", Toast.LENGTH_SHORT).show();
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
}
