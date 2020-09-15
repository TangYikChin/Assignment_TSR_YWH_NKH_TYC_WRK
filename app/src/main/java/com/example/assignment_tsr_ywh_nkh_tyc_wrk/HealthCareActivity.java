package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class HealthCareActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView mask;
    ImageView sanitizer;
    ImageView vitamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);
        mask = (ImageView) findViewById(R.id.imageView5);
        sanitizer = (ImageView) findViewById(R.id.imageView);
        vitamin = (ImageView) findViewById(R.id.imageView11);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Health Care Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Mask.class));
            }
        });

        sanitizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Sanitizer.class));
            }
        });

        vitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Vitamin.class));
            }
        });
    }
}