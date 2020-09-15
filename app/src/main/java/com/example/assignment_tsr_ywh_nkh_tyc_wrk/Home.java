package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class Home extends AppCompatActivity{
private Spinner spinner;
private Toolbar toolbar;
ImageView image1, image2, image3, image4;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        spinner = findViewById(R.id.product_list);
        toolbar = findViewById(R.id.toolbar);
        image1 = (ImageView) findViewById(R.id.imageView3);
        image2 = (ImageView) findViewById(R.id.imageView4);
        image3 = (ImageView) findViewById(R.id.imageView);
        image4 = (ImageView) findViewById(R.id.imageView2);

        setSupportActionBar(toolbar);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Clothed1Product.class));
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Clothed2Product.class));
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Sanitizer.class));
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Mask.class));
            }
        });

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
                        startActivity(new Intent(getApplicationContext(), LimitedActivity.class));
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
            return true;

            case R.id.action_cart:
                startActivity(new Intent(getApplicationContext(), Cart.class));
                return true;

            case R.id.action_about_us:
                startActivity(new Intent(getApplicationContext(), AboutUs.class));
                return true;
        }
        return super.onOptionsItemSelected(item);

    }



}
