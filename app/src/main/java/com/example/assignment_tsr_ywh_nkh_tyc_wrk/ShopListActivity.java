package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ShopListActivity extends AppCompatActivity {

    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

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
                        Intent intent = new Intent(ShopListActivity.this, limited_class.class);
                        startActivity(intent);
                    }
                    if (parent.getItemAtPosition(position).equals("Clothed")){
                        Intent intent = new Intent(ShopListActivity.this, ClothedActivity.class);
                        startActivity(intent);
                    }
                    if(parent.getItemAtPosition(position).equals("Health Care")){
                        Intent intent = new Intent(ShopListActivity.this, HealthCareActivity.class);
                        startActivity(intent);
                    }
                    if(parent.getItemAtPosition(position).equals("Electronic Device")){
                        Intent intent = new Intent(ShopListActivity.this, ElectronicDeviceActivity.class);
                        startActivity(intent);
                    }

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}