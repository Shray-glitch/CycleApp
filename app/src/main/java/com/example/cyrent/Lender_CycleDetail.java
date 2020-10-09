package com.example.cyrent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class Lender_CycleDetail extends AppCompatActivity {
    boolean isCheckDone1 = false;
    boolean isCheckDone2 = false;
    boolean isCheckDone3 = false;
    boolean isCheckDone4 = false;
    boolean isCheckDone5 = false;
    boolean isCheckDone6 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lender__cycle_detail);
        final LottieAnimationView lottieCheckDone1=findViewById(R.id.lottieCheck1);
        lottieCheckDone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone1){
                    lottieCheckDone1.setSpeed(-3);
                    lottieCheckDone1.playAnimation();
                    isCheckDone1=false;
                }else{
                    lottieCheckDone1.setSpeed(3);
                    lottieCheckDone1.playAnimation();
                    isCheckDone1=true;
                }
            }
        });
        final LottieAnimationView lottieCheckDone2=findViewById(R.id.lottieCheck2);
        lottieCheckDone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone1){
                    lottieCheckDone2.setSpeed(-3);
                    lottieCheckDone2.playAnimation();
                    isCheckDone2=false;
                }else{
                    lottieCheckDone2.setSpeed(3);
                    lottieCheckDone2.playAnimation();
                    isCheckDone2=true;
                }
            }
        });
        final LottieAnimationView lottieCheckDone3=findViewById(R.id.lottieCheck3);
        lottieCheckDone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone3){
                    lottieCheckDone3.setSpeed(-3);
                    lottieCheckDone3.playAnimation();
                    isCheckDone3=false;
                }else{
                    lottieCheckDone3.setSpeed(3);
                    lottieCheckDone3.playAnimation();
                    isCheckDone3=true;
                }
            }
        });
        final LottieAnimationView lottieCheckDone4=findViewById(R.id.lottieCheck4);
        lottieCheckDone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone4){
                    lottieCheckDone4.setSpeed(-3);
                    lottieCheckDone4.playAnimation();
                    isCheckDone4=false;
                }else{
                    lottieCheckDone4.setSpeed(3);
                    lottieCheckDone4.playAnimation();
                    isCheckDone4=true;
                }
            }
        });
        final LottieAnimationView lottieCheckDone5=findViewById(R.id.lottieCheck5);
        lottieCheckDone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone5){
                    lottieCheckDone5.setSpeed(-3);
                    lottieCheckDone5.playAnimation();
                    isCheckDone5=false;
                }else{
                    lottieCheckDone5.setSpeed(3);
                    lottieCheckDone5.playAnimation();
                    isCheckDone5=true;
                }
            }
        });
        final LottieAnimationView lottieCheckDone6=findViewById(R.id.lottieCheck6);
        lottieCheckDone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone6){
                    lottieCheckDone6.setSpeed(-3);
                    lottieCheckDone6.playAnimation();
                    isCheckDone6=false;
                }else{
                    lottieCheckDone6.setSpeed(3);
                    lottieCheckDone6.playAnimation();
                    isCheckDone6=true;
                }
            }
        });
    }
}