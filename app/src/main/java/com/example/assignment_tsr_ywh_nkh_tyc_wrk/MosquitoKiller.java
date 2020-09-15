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

public class MosquitoKiller extends AppCompatActivity implements View.OnClickListener{

        Toolbar toolbar;
        Button addToChartButton;
        Button buttonBlack,buttonWhite;
        Button plus, minus;
        EditText sizeno;
        RatingBar ratingBar;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mosquito_killer);

            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Electronic Device Product Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            buttonBlack = (Button) findViewById(R.id.button_black);
            buttonWhite = (Button) findViewById(R.id.button_white);

            buttonBlack.setOnClickListener(this);
            buttonWhite.setOnClickListener(this);

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



        }


        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_white:
                    Toast.makeText(this,"White color was selected",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_black:
                    Toast.makeText(this,"Black color was selected",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

