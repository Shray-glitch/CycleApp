package com.example.cyrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
            public void onClick(View v) {

                String email = EmailLender.getText().toString();
                String password = PasswordLender.getText().toString();
                RegisterLender(email, password);
            }
        });



    }

    private void RegisterLender(String email, String password) {

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(LenderLoginRegisterActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(LenderLoginRegisterActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
        }

        else  {

            loadingBar.setTitle("Lender Registration");
            loadingBar.setMessage("Please Wait");
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                   if (task.isSuccessful())
                   {
                       Toast.makeText(LenderLoginRegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                       loadingBar.dismiss();
                   }
                   else
                       {
                       Toast.makeText(LenderLoginRegisterActivity.this, "Register Unsuccessful", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                       }
                }
            });

        }


    }
}