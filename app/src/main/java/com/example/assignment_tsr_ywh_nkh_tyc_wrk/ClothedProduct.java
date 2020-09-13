package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ClothedProduct extends AppCompatActivity {
    Button addToChartButton;
    Button buttonM,buttonL,buttonXL;
    Button plus, minus;
    EditText sizeno;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothed1);
        setContentView(R.layout.clothed2);
        setContentView(R.layout.clothed3);

        buttonM = (Button) findViewById(R.id.button_m);
        buttonL = (Button) findViewById(R.id.button_l);
        buttonXL = (Button) findViewById(R.id.button_xl);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        sizeno = (EditText) findViewById(R.id.sizeno);
        final int [] number = {0};
        sizeno.setText(""+number[0]);
        addToChartButton = (Button) findViewById(R.id.add_to_cart_button);
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        LayerDrawable stars = (LayerDrawable)ratingBar.getProgressDrawable();

        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (number[0]==0){
                    sizeno.setText(""+number[0]);
                }

                if(number[0]>0){
                    number[0] = number[0]-1;
                    sizeno.setText(""+number[0]);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number[0]==9){
                    sizeno.setText(""+number[0]);
                }
                if(number[0]<9){
                    number[0] = number[0] +1;
                    sizeno.setText(""+number[0]);
                }
            }



        });

        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clickOfSize("1");
            }
        });

        buttonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clickOfSize("2");
            }
        });

        buttonXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clickOfSize("3");
            }
        });
    }

    private void clickOfSize(String s)
    {
        buttonM.setVisibility(View.GONE);
        buttonL.setVisibility(View.GONE);
        buttonXL.setVisibility(View.GONE);

        if(s.equalsIgnoreCase("1")){
            buttonM.setVisibility(View.VISIBLE);
        }

        if(s.equalsIgnoreCase("2")){
            buttonL.setVisibility(View.VISIBLE);
        }

        if(s.equalsIgnoreCase("3")){
            buttonXL.setVisibility(View.VISIBLE);
        }
    }



}