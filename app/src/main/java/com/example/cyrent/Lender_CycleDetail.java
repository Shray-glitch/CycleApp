package com.example.cyrent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class Lender_CycleDetail extends AppCompatActivity {
    boolean isCheckDone = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lender__cycle_detail);
        final LottieAnimationView lottieCheckDone=findViewById(R.id.lottieCheck1);
        lottieCheckDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone){
                    lottieCheckDone.setSpeed(-3);
                    lottieCheckDone.playAnimation();
                    isCheckDone=false;
                }else{
                    lottieCheckDone.setSpeed(3);
                    lottieCheckDone.playAnimation();
                    isCheckDone=true;
                }
            }
        });
    }
}