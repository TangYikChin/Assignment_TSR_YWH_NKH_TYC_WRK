package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Home extends AppCompatActivity{
private Spinner spinner;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        spinner = findViewById(R.id.product_list);

        List<String> product=new ArrayList<>();
        product.add(0,"Product List");
        product.add("Limited Product");
        product.add("Clothed");
        product.add("Health Care");
        product.add("Electronic Device");

        ArrayAdapter<String> dataAdapter;
        dataAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,product);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(dataAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Product List"))
                {

                }
                else {
                    if (parent.getItemAtPosition(position).equals("Limited Product")) {
                        startActivity(new Intent(getApplicationContext(), LimitedClass.class));
                    }
                    if (parent.getItemAtPosition(position).equals("Clothed")){
                        startActivity(new Intent(getApplicationContext(), ClothedActivity.class));
                    }
                    if(parent.getItemAtPosition(position).equals("Health Care")){
                        startActivity(new Intent(getApplicationContext(), HealthCareActivity.class));
                    }
                    if(parent.getItemAtPosition(position).equals("Electronic Device")){
                        startActivity(new Intent(getApplicationContext(), ElectronicDeviceActivity.class));
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionalmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
        case R.id.user_account:
            startActivity(new Intent(getApplicationContext(), UserAcc.class));
            Toast.makeText(Home.this, "Please Work", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
