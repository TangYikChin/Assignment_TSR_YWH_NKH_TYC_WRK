package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class limited_class extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limited_product);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
