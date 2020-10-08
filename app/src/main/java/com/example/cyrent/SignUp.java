package com.example.cyrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    private EditText regName;
    private EditText regEmail;
    private EditText regPassword;
    private EditText regPassword_verify;
    private Button regBtn;
    private FirebaseAuth mAuth;
   // private ProgressBar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        regName=findViewById(R.id.Name);
        regEmail=findViewById(R.id.Email);
        EditText regPhoneno = findViewById(R.id.PhoneNo);
        regPassword=findViewById(R.id.Password);
        regPassword_verify=findViewById(R.id.Password_verify);
        regBtn= (Button) findViewById(R.id.Register);

       regBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String email = regEmail.getText().toString();
               String password = regPassword.getText().toString();
               RegisterLender(email, password);
           }
       });
    }
    private void RegisterLender(String email, String password) {

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(SignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(SignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
        }

        else  {



            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(SignUp.this, "Register Successful", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(SignUp.this, "Register Unsuccessful", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }


    }
}