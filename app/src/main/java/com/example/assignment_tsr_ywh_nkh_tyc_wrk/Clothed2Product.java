package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Clothed2Product extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    Button addToChartButton;
    Button buttonM,buttonL,buttonXL;
    Button plus, minus;
    EditText sizeno;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothed2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cloth Product Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonM = (Button) findViewById(R.id.button_m);
        buttonL = (Button) findViewById(R.id.button_l);
        buttonXL = (Button) findViewById(R.id.button_xl);
        buttonM.setOnClickListener(this);
        buttonL.setOnClickListener(this);
        buttonXL.setOnClickListener(this);
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
                if(number[0]==100){
                    sizeno.setText(""+number[0]);
                }
                if(number[0]<100){
                    number[0] = number[0] +1;
                    sizeno.setText(""+number[0]);
                }
            }



        });



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_m:
                Toast.makeText(this,"M size was selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_l:
                Toast.makeText(this,"L size was selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_xl:
                Toast.makeText(this,"XL size was selected",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}