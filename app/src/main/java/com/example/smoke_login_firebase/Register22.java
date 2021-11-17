package com.example.smoke_login_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register22 extends AppCompatActivity {

    private EditText Name;
    private EditText Age;
    private EditText Email;
    private EditText Password1;
    private EditText Password2;
    private Button Register;
    private Button Create;
    private TextView Already;
    private TextView Name_t;
    private TextView Age_t;
    private TextView Gender_t;
    private TextView Email_t;
    private TextView Password_1t;
    private TextView Password_2t;
    private RadioGroup Radiogroup;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register22);

        Name = (EditText) findViewById(R.id.edit_name);
        Age = (EditText) findViewById(R.id.edit_age);
        Email = (EditText) findViewById(R.id.edit_mail);
        Password1 = (EditText) findViewById(R.id.edit_password);
        Password2 = (EditText) findViewById(R.id.edit_password2);
        Register = (Button) findViewById(R.id.edit_button);
        Create = (Button) findViewById(R.id.create_btt);
        Already = (TextView) findViewById(R.id.already);
        Name_t = (TextView) findViewById(R.id.tv_name);
        Age_t = (TextView) findViewById(R.id.tv_age);
        Gender_t = (TextView) findViewById(R.id.tv_gender);
        Email_t = (TextView) findViewById(R.id.tv_email);
        Password_1t= (TextView) findViewById(R.id.tv_pw);
        Password_2t= (TextView) findViewById(R.id.tv_pw2);
        Radiogroup = (RadioGroup) findViewById(R.id.radiogrp);


        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            Intent intent = new Intent(Register22.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String password1 = Password1.getText().toString().trim();
                String password2 = Password2.getText().toString().trim();


                String name = Name.getText().toString().trim();
                String age = Age.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)) {
                    Name.setError("Please fill all the details");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Email.setError ("Email is required!");
                    return;
                }

                if (TextUtils.isEmpty(password1)) {
                    Password1.setError ("Both passwords are required!");
                    return;
                }

                if (TextUtils.isEmpty(password2)) {
                    Password2.setError ("Both passwords are required!");
                    return;
                }

                if (!password1.equals(password2)) {
                    Password1.setError ("Both passwords are not matching!");
                    return;
                }

                    mAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                            Toast.makeText(Register22.this, "Successful registration. Please check your email id.", Toast.LENGTH_SHORT).show();

                                            Intent intent = new Intent(Register22.this, Login.class);
                                            startActivity(intent);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Register22.this, "Unsuccessful registration. Please input a valid email id.", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    });

            }
        });

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register22.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}