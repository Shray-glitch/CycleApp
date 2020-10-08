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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LenderLoginRegisterActivity extends AppCompatActivity {

    private Button LenderLoginButton, LenderRegisterButton;
    private TextView LenderRegisterLink;
    private EditText EmailLender, PasswordLender;
    private ProgressBar loadingBar;

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
        //  loadingBar = new ProgressDialog(this);

        LenderRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LenderLoginRegisterActivity.this, SignUp.class);
                startActivity(intent);


            }
        });

        LenderLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String L_email = EmailLender.getText().toString().trim();
                String L_password = PasswordLender.getText().toString().trim();

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

                loadingBar.setVisibility(View.VISIBLE);
                //create user
                mAuth.createUserWithEmailAndPassword(L_email, L_password).addOnCompleteListener(LenderLoginRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LenderLoginRegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        loadingBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(LenderLoginRegisterActivity.this, "Authentication failed." + task.getException(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(LenderLoginRegisterActivity.this, Lender_CycleDetail.class));
                            finish();
                        }
                    }
                });


            }
        });
    }
}


