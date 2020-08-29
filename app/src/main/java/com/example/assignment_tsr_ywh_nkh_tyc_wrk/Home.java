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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Home extends AppCompatActivity{


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Spinner spinner = findViewById(R.id.product_list);

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
                        Intent intent = new Intent(Home.this, LimitedClass.class);
                        startActivity(intent);
                    }
                    if (parent.getItemAtPosition(position).equals("Clothed")){
                        Intent intent = new Intent(Home.this, ClothedActivity.class);
                        startActivity(intent);
                    }
                    if(parent.getItemAtPosition(position).equals("Health Care")){
                        Intent intent = new Intent(Home.this, HealthCareActivity.class);
                        startActivity(intent);
                    }
                    if(parent.getItemAtPosition(position).equals("Electronic Device")){
                        Intent intent = new Intent(Home.this, ElectronicDeviceActivity.class);
                        startActivity(intent);
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
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.user_account){
            startActivity(new Intent(getApplicationContext(), UserAcc.class));
            return false;
        }
        return super.onOptionsItemSelected(item);
    }


}
