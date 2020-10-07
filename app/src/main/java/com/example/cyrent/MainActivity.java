package com.example.cyrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// driver = lender, customer = rider
public class MainActivity extends AppCompatActivity {

    //private Button WelcomeLenderButton;
    //private Button WelcomeRiderButton;
    private Button mLender, mRider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // WelcomeLenderButton = (Button) findViewById(R.id.lender);
        //WelcomeRiderButton = (Button) findViewById(R.id.rider);
        mLender = (Button) findViewById(R.id.lender);
        mRider = (Button) findViewById(R.id.rider);

        mLender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterLenderIntent = new Intent(MainActivity.this, LenderLoginRegisterActivity.class) ;
                startActivity(LoginRegisterLenderIntent);
            }
        });

        mRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterRiderIntent = new Intent(MainActivity.this, RiderLoginRegisterActivity.class) ;
                startActivity(LoginRegisterRiderIntent);
            }
        });

    }
}