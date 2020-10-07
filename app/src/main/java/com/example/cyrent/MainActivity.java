package com.example.cyrent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

// driver = lender
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


    }
}