package com.example.cyrent.Utils;

import android.content.Context;
import android.media.session.MediaSession;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.provider.FontsContractCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.cyrent.Common;
import com.example.cyrent.Model.TokenModel;
import com.example.cyrent.Services.MyFirebaseMessagingService;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class UserUtils {
    public static void updateUser(View view, Map<String, Object> updateData) {
        FirebaseDatabase.getInstance()
                .getReference(Common.DRIVER_INFO_REFERENCE)
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .updateChildren(updateData)
                .addOnFailureListener(e -> Snackbar.make(view,e.getMessage(),Snackbar.LENGTH_SHORT).show())
                .addOnSuccessListener(aVoid -> Snackbar.make(view,"Update information successfully!",Snackbar.LENGTH_SHORT).show());
    }

    public static void updateToken(Context context, String token) {
        TokenModel tokenModel= new TokenModel(token);

        FirebaseDatabase.getInstance()
                .getReference(Common.TOKEN_REFERENCE)
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .setValue(tokenModel)
                .addOnFailureListener(e -> Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show())
                .addOnSuccessListener(aVoid -> {

                });

    }
}