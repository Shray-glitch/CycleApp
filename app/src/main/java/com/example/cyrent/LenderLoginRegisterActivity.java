/*package com.example.cyrent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.client.AuthUiInitProvider;
import com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LenderLoginRegisterActivity extends AppCompatActivity {


    private final static int LOGIN_REQUEST_CODE= 7171;
    private List<AuthUI.IdpConfig> providers;
    private FirebaseAuth.AuthStateListener listener;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(listener);
    }

    @Override
    protected void onStop() {
        if(mAuth !=null && listener !=null)
            mAuth.removeAuthStateListener(listener);
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_lender_login_register);
         init();

        mAuth = FirebaseAuth.getInstance();

    }

    private void init(){
        providers= Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());
        mAuth = FirebaseAuth.getInstance();
listener=myFirebaseAuth -> {
   FirebaseUser user= myFirebaseAuth.getCurrentUser();
   if(user !=null){

       Intent Lender_CycleDetail = new Intent(LenderLoginRegisterActivity.this, LenderHomeActivity.class) ;
       startActivity(Lender_CycleDetail);

   }
   else
       showLoginLayout();
     };
    }

    private void showLoginLayout(){
        AuthMethodPickerLayout authMethodPickerLayout=new AuthMethodPickerLayout
        .Builder(R.layout.activity_lender_login_register)
        .setPhoneButtonId(R.id.btn_phone_signin)
        .setGoogleButtonId(R.id.btn_google_signin)
        .build();

        startActivityForResult(AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAuthMethodPickerLayout(authMethodPickerLayout)
        .setIsSmartLockEnabled(false)
        .setAvailableProviders(providers)
        .build(),LOGIN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LOGIN_REQUEST_CODE){
            IdpResponse response=IdpResponse.fromResultIntent(data);
            if(requestCode == RESULT_OK)
            {
                FirebaseUser user = mAuth.getInstance().getCurrentUser();
            }
            else
            {
                Toast.makeText(this,"[ERROR]"+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}*/