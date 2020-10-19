package com.example.cyrent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.example.cyrent.Model.CycleDetailUserData;
import com.example.cyrent.Utils.UserUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class Lender_CycleDetail extends AppCompatActivity {
    boolean isCheckDone1 = false;
    boolean isCheckDone4 = false;
    boolean isCheckDone5 = false;
    boolean isCheckDone6 = false;
    private EditText CycleBrand;

    private static final int PICK_IMAGE_REQUEST_CYCLE=5911;
    private Uri imageuri_cycle;
    private ImageView img_cycle;
    private AlertDialog waitingDialog;
    private StorageReference storageReference;


    private FirebaseAuth mAuth;
    private Button goBtn;
    FirebaseDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        myDatabase= FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_lender__cycle_detail);

        storageReference= FirebaseStorage.getInstance().getReference();

        img_cycle=findViewById(R.id.cycle_photo);
        img_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,PICK_IMAGE_REQUEST_CYCLE);
            }
        });
        if(Common.currentUser !=null && Common.currentUser.getCycle() !=null &&
                !TextUtils.isEmpty(Common.currentUser.getCycle()))
        {
            Glide.with(this)
                    .load(Common.currentUser.getCycle())
                    .into(img_cycle);
        }


        CycleBrand=findViewById(R.id.brand);

        goBtn= (Button) findViewById(R.id.go_btn);






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
                    myDatabase.getReference().child("DriverInfo").child(mAuth.getUid()).child("CycleData").setValue(cycleDetailRecord);

                    Toast.makeText(Lender_CycleDetail.this, "Cycle Added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Lender_CycleDetail.this, LenderHomeActivity.class) ;
                    startActivity(intent);

                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST_CYCLE && resultCode == Activity.RESULT_OK)
        {
            if(data!=null && data.getData()!=null)
            {
                imageuri_cycle=data.getData();
                img_cycle.setImageURI(imageuri_cycle);

                showDialogUploadCycle();
            }
        }
    }

    private void showDialogUploadCycle(){

        waitingDialog=new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("Waiting...")
                .create();

        AlertDialog.Builder builder = new AlertDialog.Builder(Lender_CycleDetail.this);
        builder.setTitle("Add Cycle")
                .setMessage("Add cycle image for better reach!")
                .setNegativeButton("CANCEL", (dialogInterface, i) -> dialogInterface.dismiss())
                .setPositiveButton("UPLOAD", (dialogInterface, i) -> {
                    if(imageuri_cycle!=null)
                    {
                        waitingDialog.setMessage("Uploading...");
                        waitingDialog.show();

                        String unique_name= FirebaseAuth.getInstance().getCurrentUser().getUid();
                        StorageReference cycleFolder = storageReference.child("Cycle_image/"+unique_name);

                        cycleFolder.putFile(imageuri_cycle)
                                .addOnFailureListener(e -> {
                                    waitingDialog.dismiss();
                                    Toast.makeText(Lender_CycleDetail.this, "Cycle image failed", Toast.LENGTH_SHORT).show();


                                }).addOnCompleteListener(task -> {
                            if(task.isSuccessful())
                            {
                                cycleFolder.getDownloadUrl().addOnSuccessListener(uri -> {
                                    Map<String,Object> updateData=new HashMap<>();
                                    updateData.put("Cycle Image",uri.toString());
                                    Toast.makeText(Lender_CycleDetail.this, "Cycle image Added", Toast.LENGTH_SHORT).show();


                                });
                            }
                        }).addOnProgressListener(taskSnapshot -> {
                            double progress =(100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            waitingDialog.setMessage(new StringBuilder("Uploading: ").append(progress).append("%"));
                            waitingDialog.dismiss();// may be wrong , if not working delete it plz

                        });
                    }
                })
                .setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(dialog1 -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setTextColor(getResources().getColor(android.R.color.holo_red_dark, null ));
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                    .setTextColor(getResources().getColor(R.color.colorAccent, null));

        });

        dialog.show();

    }
}