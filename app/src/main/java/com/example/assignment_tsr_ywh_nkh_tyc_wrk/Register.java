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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    Button bRegister;
    EditText etUsername, etEmail, etPassword, etConfirmPassword, etPhone;
    FirebaseAuth fAuth;
    DatabaseReference reference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        bRegister = (Button) findViewById(R.id.bRegister);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        etPhone = (EditText) findViewById(R.id.etPhone);
        user = new User();
        fAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("User").child("1");

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();

                user.setUsername(etUsername.getText().toString().trim());
                user.setEmail(etEmail.getText().toString().trim());
                user.setPassword(etPassword.getText().toString().trim());
                user.setConfirmPassword(etConfirmPassword.getText().toString().trim());
                user.setPhone(etPhone.getText().toString().trim());


                reference.push().setValue(user);
                Toast.makeText(Register.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();

                if (TextUtils.isEmpty(username)){
                    etUsername.setError("Username is Required!");
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    etEmail.setError("Email is Required!");
                    return;
                }

                if (TextUtils.isEmpty(phone)){
                    etPhone.setError("Phone Number is Required!");
                    return;
                }

                if (phone.length() > 11 || phone.length() <10){
                    etPhone.setError("Invalid Phone Format");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    etPassword.setError("Password is Required!");
                    return;
                }

                if (password.length() < 6){
                    etPassword.setError("Password Must be More than 6 characters!");
                    return;
                }


                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                        else{
                            Toast.makeText(Register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}