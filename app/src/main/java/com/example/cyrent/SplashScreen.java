package com.example.cyrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SplashScreen extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    private Button mLender, mRider;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        //    rellay2.setVisibility(View.VISIBLE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
       // rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash



        mLender = (Button) findViewById(R.id.lender);
        mRider = (Button) findViewById(R.id.rider);

        mLender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterLenderIntent = new Intent(SplashScreen.this, LenderLoginRegisterActivity.class) ;
                startActivity(LoginRegisterLenderIntent);
            }
        });

        mRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterRiderIntent = new Intent(SplashScreen.this, RiderLoginRegisterActivity.class) ;
                startActivity(LoginRegisterRiderIntent);
            }
        });
    }
}