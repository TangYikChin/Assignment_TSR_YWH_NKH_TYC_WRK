package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



public class ElectronicDeviceActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView electronic1;
    ImageView electronic2;
    ImageView electronic3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic_device);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        electronic1 = (ImageView) findViewById(R.id.imageView8);
        electronic2 = (ImageView) findViewById(R.id.imageView9);
        electronic3 = (ImageView) findViewById(R.id.imageView10);

        getSupportActionBar().setTitle("Electronic Device Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        electronic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MosquitoKiller.class));
            }
        });
        electronic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MosquitoKiller.class));
            }
        });
        electronic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MosquitoKiller.class));
            }
        });

    }
}