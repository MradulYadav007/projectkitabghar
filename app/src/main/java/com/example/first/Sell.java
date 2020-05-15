package com.example.first;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Sell extends AppCompatActivity {
    private static final int PICK_IMAGE_REGUEST = 1;
    Button b1, b2, b3, b4;
    EditText e1;
    ImageView i1;
    ProgressBar p1;
    private Uri mimage;
    private StorageReference mstorage;
    private DatabaseReference mdatabase;
    private StorageTask mstoragetask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        b1 = (Button) findViewById(R.id.button5);
        b2 = (Button) findViewById(R.id.button6);
        b3 = (Button) findViewById(R.id.button7);
        b4 = (Button) findViewById(R.id.button8);
        i1 = (ImageView) findViewById(R.id.imageView2);
        e1=(EditText)findViewById(R.id.editText3) ;
        p1 = (ProgressBar) findViewById(R.id.progress_bar);

        mstorage = FirebaseStorage.getInstance().getReference("uploads");
        mdatabase = FirebaseDatabase.getInstance().getReference("uploads");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sell.this, Welcome.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfilechooser();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mstoragetask!=null && mstoragetask.isInProgress()){
                    Toast.makeText(Sell.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                }
                else
                uploadFile();
            }
        });
    }

    private void openfilechooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       /* if (requestCode ==1 && resultCode == RESULT_OK  && data != null && data.getAction() != null) {*/
            mimage = data.getData();
            Toast.makeText(this, "Image viewed", Toast.LENGTH_SHORT).show();
           // Picasso.with(this).load(mimage).into(i1);
            i1.setImageURI(mimage);
        }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mip = MimeTypeMap.getSingleton();
        return mip.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile() {
        if (mimage != null) {
            StorageReference fileReference=mstorage.child(System.currentTimeMillis()
            +"."+getFileExtension(mimage));
            mstoragetask=fileReference.putFile(mimage)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    p1.setProgress(0);
                                }
                            },5000);
                            Toast.makeText(Sell.this, "Upload successfull", Toast.LENGTH_SHORT).show();
                          Upload upload=new Upload(e1.getText().toString().trim(),
                                    taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
                            String uploadId=mdatabase.push().getKey();
                            mdatabase.child(uploadId).setValue(upload);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Sell.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progress=(100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            p1.setProgress((int) progress);

                        }
                    });
        } else {
            Toast.makeText(this, "Please Pick a file", Toast.LENGTH_SHORT).show();
        }
    }
}