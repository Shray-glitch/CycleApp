package com.example.cyrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LenderLoginRegisterActivity extends AppCompatActivity {

    private Button LenderLoginButton, LenderRegisterButton, MapButton;
    private TextView LenderRegisterLink;
    EditText EmailLender, PasswordLender;
  //  private ProgressBar loadingBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lender_login_register);

        mAuth = FirebaseAuth.getInstance();
        LenderLoginButton = (Button) findViewById(R.id.login);

        LenderRegisterButton = (Button) findViewById(R.id.register);
        //   LenderRegisterLink = (TextView) findViewById(R.id.)
        EmailLender = (EditText) findViewById(R.id.Email_lender);
        PasswordLender = (EditText) findViewById(R.id.Password_lender);
        //  loadingBar = new ProgressDialog(this);
        MapButton = (Button) findViewById(R.id.map);
        // loadingBar = new ProgressDialog(this);

        LenderRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LenderLoginRegisterActivity.this, SignUp.class);
                startActivity(intent);


            }
        });


       MapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MapActivity = new Intent(LenderLoginRegisterActivity.this, LenderMapActivity.class) ;
                startActivity(MapActivity);
            }
        });


        LenderLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String L_email = EmailLender.getText().toString();
                String L_password = PasswordLender.getText().toString();

                if (TextUtils.isEmpty(L_email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(L_password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (L_password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

               // loadingBar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(L_email,L_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(LenderLoginRegisterActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                            Intent Lender_CycleDetail = new Intent(LenderLoginRegisterActivity.this, Lender_CycleDetail.class) ;
                            startActivity(Lender_CycleDetail);

                        }
                        else
                        {
                            Toast.makeText(LenderLoginRegisterActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LenderLoginRegisterActivity.this, SignUp.class) ;
                            startActivity(intent);
                        }
                    }
                });



            }
        });
    }


}