package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class ElectronicDeviceActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic_device);
        toolbar = findViewById(R.id.toolbar);
        imageView1 = findViewById(R.id.imageView8);
        imageView2 = findViewById(R.id.imageView9);
        imageView3 = findViewById(R.id.imageView10);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Electronic Device Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ));
            }
        });
    }
}