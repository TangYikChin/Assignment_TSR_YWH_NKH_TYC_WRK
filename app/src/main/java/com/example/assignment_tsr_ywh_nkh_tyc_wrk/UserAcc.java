package com.example.assignment_tsr_ywh_nkh_tyc_wrk;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserAcc extends AppCompatActivity {
    TextView cgUsername, cgEmail, cgPhone;
    Button blogout;
    DatabaseReference reference;
    FirebaseAuth fAuth;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useracc);
        cgUsername = findViewById(R.id.cgUsername);
        cgEmail = findViewById(R.id.cgEmail);
        cgPhone = findViewById(R.id.cgPhone);
        blogout = findViewById(R.id.blogout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("User").child("1").child("-MG3fvwu9BQi8JR_4iwq");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserGetSet userGetSet = dataSnapshot.getValue(UserGetSet.class);
                cgUsername.setText(userGetSet.getUsername());
                cgEmail.setText(userGetSet.getEmail());
                cgPhone.setText(userGetSet.getPhone());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UserAcc.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(UserAcc.this, "User Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
