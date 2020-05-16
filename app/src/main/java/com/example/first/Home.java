package com.example.first;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser!=null){
            Intent i=new Intent(Home.this,Welcome.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }

    }
}
