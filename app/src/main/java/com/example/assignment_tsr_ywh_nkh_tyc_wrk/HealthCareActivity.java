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
    ImageView handsanitizer;
    ImageView vitamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mask = (ImageView) findViewById(R.id.imageView);
        handsanitizer = (ImageView) findViewById(R.id.imageView5);
        vitamin = (ImageView) findViewById(R.id.imageView11);

        getSupportActionBar().setTitle("Limited Class");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HealthCareProduct.class));
            }
        });

        handsanitizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HealthCareProduct.class));
            }
        });

        vitamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HealthCareProduct.class));
            }
        });
    }
}