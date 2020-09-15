package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Nintendo extends AppCompatActivity implements View.OnClickListener {
    TextView productName, productPrice;
    Toolbar toolbar;
    Button addToChartButton;
    Button buttonGrey,buttonNeon;
    Button plus, minus;
    EditText sizeno;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nintendo_switch_v2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Limited Product Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonGrey = (Button) findViewById(R.id.button_grey);
        buttonNeon = (Button) findViewById(R.id.button_neon);


        buttonGrey.setOnClickListener(this);
        buttonNeon.setOnClickListener(this);

        productName = (TextView) findViewById(R.id.nintendoName);
        productPrice = (TextView) findViewById(R.id.nintendoPrice);

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

        addToChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String saveCurrentTime, saveCurrentDate;

                Calendar calForDate = Calendar.getInstance();
                SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, YYYY");
                saveCurrentDate = currentDate.format(calForDate.getTime());

                SimpleDateFormat currentTime = new SimpleDateFormat("HH:MM:SS a");
                saveCurrentTime = currentDate.format(calForDate.getTime());

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Cart List");

                final HashMap<String , Object> cartMap = new HashMap<>();
                cartMap.put("pName", productName.getText().toString());
                cartMap.put("price", productPrice.getText().toString());
                cartMap.put("date", saveCurrentDate);
                cartMap.put("time", saveCurrentTime);
                cartMap.put("quantity", sizeno.getText().toString());

                reference.child("User View").child("Product").child(productName.getText().toString()).updateChildren(cartMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Nintendo.this, "Added To Cart List!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_grey:
                Toast.makeText(this,"Grey color was selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_neon:
                Toast.makeText(this,"Neon color was selected",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

