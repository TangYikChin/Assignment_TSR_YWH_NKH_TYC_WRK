package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class LimitedActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView realmi;
    ImageView redmi;
    ImageView nintendo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_limited_product);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        realmi = (ImageView) findViewById(R.id.imageView13);
        redmi = (ImageView) findViewById(R.id.imageView14);
        nintendo = (ImageView) findViewById(R.id.imageView16);

        getSupportActionBar().setTitle("Limited Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        realmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LimitedProduct.class));
            }
        });
        redmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LimitedProduct.class));
            }
        });
        nintendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LimitedProduct.class));
            }
        });

    }
}
