package com.example.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    TextView t1, t2, t3, t4, t5, t6;
    EditText e1, e2, e3, e4;
    FirebaseAuth mAuth;
    DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        e1 = (EditText) findViewById(R.id.editText4);
        e2 = (EditText) findViewById(R.id.editText5);
        e3 = (EditText) findViewById(R.id.editText6);
        e4 = (EditText) findViewById(R.id.editText7);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("Users");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = e1.getText().toString();
                String password = e3.getText().toString();
                final String email = e2.getText().toString();
                final String phone = e4.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Please Enter email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please Enter password", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(MainActivity.this, "Please Enter username", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(MainActivity.this, "Please Enter phone number", Toast.LENGTH_SHORT).show();
                }
                if (!(TextUtils.isEmpty(email)) && !(TextUtils.isEmpty(password)) && !(TextUtils.isEmpty(username)) && !(TextUtils.isEmpty(phone))) {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!(task.isSuccessful())) {
                                        Userdetail information = new Userdetail(username, email, phone);
                                        FirebaseDatabase.getInstance().getReference("Users")
                                                .child(FirebaseAuth.getInstance().getUid())
                                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(MainActivity.this, "User successfully Registered", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(getApplicationContext(),Login.class));
                                            }
                                        });
                                    }

                                }
                            });
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });
    }
}
