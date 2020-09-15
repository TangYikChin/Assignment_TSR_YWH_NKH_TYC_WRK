package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ConfirmFinalOrder extends AppCompatActivity {

    EditText etUsernameConfirm, etPhoneConfirm, etHomeAddressConfirm, etCityConfirm;
    Button bConfirm;

    String totalAmount = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_final_order);

        totalAmount = getIntent().getStringExtra("Total Price: ");

        bConfirm = findViewById(R.id.bConfirm);
        etUsernameConfirm = findViewById(R.id.etUsernameConfirm);
        etPhoneConfirm = findViewById(R.id.etPhoneConfirm);
        etHomeAddressConfirm = findViewById(R.id.etHomeAddressConfirm);
        etCityConfirm = findViewById(R.id.etCityConfirm);

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check();
            }
        });

    }

            private void Check() {
                if (etPhoneConfirm.length() > 11 || etPhoneConfirm.length() <10){
                    Toast.makeText(ConfirmFinalOrder.this, "Invalid Phone Format", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(etUsernameConfirm.getText().toString())){
                    Toast.makeText(ConfirmFinalOrder.this, "Please Provide User Name", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(etPhoneConfirm.getText().toString())){
                    Toast.makeText(ConfirmFinalOrder.this, "Please Provide Phone Number", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(etHomeAddressConfirm.getText().toString())){
                    Toast.makeText(ConfirmFinalOrder.this, "Please Provide Address", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(etCityConfirm.getText().toString())){
                    Toast.makeText(ConfirmFinalOrder.this, "Please Provide City Name", Toast.LENGTH_SHORT).show();
                }

                else {
                    ConfirmOrder();
                }

            }

            private void ConfirmOrder() {
                String saveCurrentDate, saveCurrentTime;

                Calendar calForDate = Calendar.getInstance();
                SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, YYYY");
                saveCurrentDate = currentDate.format(calForDate.getTime());

                SimpleDateFormat currentTime = new SimpleDateFormat("HH:MM:SS a");
                saveCurrentTime = currentDate.format(calForDate.getTime());

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Order");

                HashMap<String, Object> orderMap = new HashMap<>();
                orderMap.put("name", etUsernameConfirm.getText().toString());
                orderMap.put("phone", etPhoneConfirm.getText().toString());
                orderMap.put("address", etHomeAddressConfirm.getText().toString());
                orderMap.put("city", etCityConfirm.getText().toString());
                orderMap.put("amount", totalAmount);

                reference.updateChildren(orderMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            FirebaseDatabase.getInstance().getReference().child("Cart List").child("User View").child("Product").removeValue()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Intent intent = new Intent(ConfirmFinalOrder.this, Home.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }
                                    });
                        }
                    }
                });

            }
}
