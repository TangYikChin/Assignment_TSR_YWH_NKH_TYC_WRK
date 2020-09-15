package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class ClothedActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView clothed1;
    ImageView clothed2;
    ImageView clothed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothed);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        clothed1 = (ImageView) findViewById(R.id.imageView6);
        clothed2 = (ImageView) findViewById(R.id.imageView7);
        clothed3 = (ImageView) findViewById(R.id.imageView12);

        getSupportActionBar().setTitle("Cloth Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clothed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Clothed1Product.class));
            }
        });

        clothed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Clothed2Product.class));
            }
        });

        clothed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Clothed3Product.class));
            }
        });
    }
}