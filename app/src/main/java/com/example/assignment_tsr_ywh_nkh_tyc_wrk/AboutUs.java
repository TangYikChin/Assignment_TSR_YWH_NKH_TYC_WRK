package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AboutUs extends AppCompatActivity {
    EditText Comment;
    Button sub;
    DatabaseReference reference;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Comment=(EditText)findViewById(R.id.Comment);
        sub=(Button)findViewById(R.id.sub);
        reference = FirebaseDatabase.getInstance().getReference().child("Review");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final HashMap<String , Object> commetMap = new HashMap<>();
                commetMap.put("comment",Comment.getText().toString());
                reference.updateChildren(commetMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AboutUs.this, "Successful Added", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });

    }
}
