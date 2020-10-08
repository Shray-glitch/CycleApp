package com.example.cyrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LenderLoginRegisterActivity extends AppCompatActivity {

    private Button LenderLoginButton,LenderRegisterButton;
    private TextView LenderRegisterLink;
    private EditText EmailLender,PasswordLender;
    private ProgressDialog loadingBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lender_login_register);

        mAuth = FirebaseAuth.getInstance();

        LenderLoginButton = (Button) findViewById(R.id.login);
        LenderRegisterButton = (Button) findViewById(R.id.register);
     //   LenderRegisterLink = (TextView) findViewById(R.id.)
        EmailLender = (EditText) findViewById(R.id.email);
        PasswordLender = (EditText) findViewById(R.id.password);
        loadingBar = new ProgressDialog(this);
        LenderRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new  Intent(LenderLoginRegisterActivity.this,SignUp.class);
                startActivity(intent);


            }
        });



    }


}