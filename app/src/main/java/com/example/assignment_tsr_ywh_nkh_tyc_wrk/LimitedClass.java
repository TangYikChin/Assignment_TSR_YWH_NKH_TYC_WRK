package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class LimitedClass extends AppCompatActivity {
    Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_limited_product);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Limited Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
