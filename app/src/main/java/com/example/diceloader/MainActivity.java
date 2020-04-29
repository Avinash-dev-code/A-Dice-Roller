package com.example.diceloader;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] dice = {1, 2, 3, 4, 5, 6};
    private LottieAnimationView lot;
    private TextView t1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.b1);
        lot = (LottieAnimationView) findViewById(R.id.lottieAnimationView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDice();
                lot.playAnimation();
            }
        });




        lot.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                showNumber();
                Random random = new Random();

                int randNum = random.nextInt(dice.length);

                t1.setText(Integer.toString(dice[randNum]));

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });



    }

    private void showDice() {
        lot.setVisibility(View.VISIBLE);

        t1.setVisibility(View.INVISIBLE);
    }

     public  void showNumber(){
         t1.setVisibility(View.VISIBLE);
         lot.setVisibility(View.INVISIBLE);

     }
}