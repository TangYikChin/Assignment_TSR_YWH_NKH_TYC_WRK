package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HealthCareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}