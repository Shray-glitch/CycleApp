package com.example.cyrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.cyrent.Model.CycleDetailUserData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Lender_CycleDetail extends AppCompatActivity {
    boolean isCheckDone1 = false;

    boolean isCheckDone4 = false;
    boolean isCheckDone5 = false;
    boolean isCheckDone6 = false;
    private EditText CycleBrand;
;
    private FirebaseAuth mAuth;
    private Button goBtn;
    FirebaseDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        myDatabase= FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_lender__cycle_detail);

        CycleBrand=findViewById(R.id.brand);

        goBtn= (Button) findViewById(R.id.go_btn);

        String CycleBrandData=CycleBrand.getText().toString();

        boolean  GearData=isCheckDone1;
        boolean  MudGuardData=isCheckDone4;
        boolean  BellData=isCheckDone5;
        boolean  CarrierData=isCheckDone6;




        final LottieAnimationView lottieCheckDone1=findViewById(R.id.lottieCheck1);
        lottieCheckDone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone1){
                    lottieCheckDone1.setSpeed(-3);
                    lottieCheckDone1.playAnimation();
                    isCheckDone1=false;
                }else{
                    lottieCheckDone1.setSpeed(3);
                    lottieCheckDone1.playAnimation();
                    isCheckDone1=true;
                }
            }
        });

        final LottieAnimationView lottieCheckDone4=findViewById(R.id.lottieCheck4);
        lottieCheckDone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone4){
                    lottieCheckDone4.setSpeed(-3);
                    lottieCheckDone4.playAnimation();
                    isCheckDone4=false;
                }else{
                    lottieCheckDone4.setSpeed(3);
                    lottieCheckDone4.playAnimation();
                    isCheckDone4=true;
                }
            }
        });
        final LottieAnimationView lottieCheckDone5=findViewById(R.id.lottieCheck5);
        lottieCheckDone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone5){
                    lottieCheckDone5.setSpeed(-3);
                    lottieCheckDone5.playAnimation();
                    isCheckDone5=false;
                }else{
                    lottieCheckDone5.setSpeed(3);
                    lottieCheckDone5.playAnimation();
                    isCheckDone5=true;
                }
            }
        });
        final LottieAnimationView lottieCheckDone6=findViewById(R.id.lottieCheck6);
        lottieCheckDone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheckDone6){
                    lottieCheckDone6.setSpeed(-3);
                    lottieCheckDone6.playAnimation();
                    isCheckDone6=false;
                }else{
                    lottieCheckDone6.setSpeed(3);
                    lottieCheckDone6.playAnimation();
                    isCheckDone6=true;
                }
            }
        });

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CycleBrandData=CycleBrand.getText().toString();

                boolean  GearData=isCheckDone1;
                boolean  MudGuardData=isCheckDone4;
                boolean  BellData=isCheckDone5;
                boolean  CarrierData=isCheckDone6;

                final CycleDetailUserData cycleDetailRecord= new CycleDetailUserData(CycleBrandData,GearData,MudGuardData,BellData,CarrierData);

                if (CycleBrandData.isEmpty())
                {
                    Toast.makeText(Lender_CycleDetail.this, "Enter Cycle Brand", Toast.LENGTH_SHORT).show();
                }
                else{
                    myDatabase.getReference().child("Users").child(mAuth.getUid()).child("CycleData").setValue(cycleDetailRecord);
                    Intent intent = new Intent(Lender_CycleDetail.this, LenderHomeActivity.class) ;
                    startActivity(intent);

                }
            }
        });
    }
}