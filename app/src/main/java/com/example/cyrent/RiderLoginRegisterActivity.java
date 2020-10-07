package com.example.cyrent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RiderLoginRegisterActivity extends AppCompatActivity {

    private Button RiderLoginButton,RiderRegisterButton;
    private TextView RiderRegisterLink;
    private EditText EmailRider,PasswordRider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_login_register);

        RiderLoginButton = (Button) findViewById(R.id.login);
        RiderRegisterButton = (Button) findViewById(R.id.register);
        //   LenderRegisterLink = (TextView) findViewById(R.id.)
        EmailRider = (EditText) findViewById(R.id.email);
        PasswordRider = (EditText) findViewById(R.id.password);

    }
}