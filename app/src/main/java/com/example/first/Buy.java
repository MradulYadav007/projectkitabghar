package com.example.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Buy extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    private ImageAdapter imageAdapter;
    private  DatabaseReference mdatabaseref;

    private List<Upload> mUpload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        mRecyclerview=findViewById(R.id.recycler_view);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mUpload=new ArrayList<>();
        mdatabaseref = FirebaseDatabase.getInstance().getReference("uploads");
        mdatabaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postseason: dataSnapshot.getChildren()){
                    Upload upload=postseason.getValue(Upload.class);
                    mUpload.add(upload);
                }
              imageAdapter= new ImageAdapter(Buy.this,mUpload);
                mRecyclerview.setAdapter(imageAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Buy.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
