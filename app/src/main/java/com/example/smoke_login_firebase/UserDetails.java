package com.example.smoke_login_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserDetails extends AppCompatActivity {
    private EditText Q1;
    private EditText Q2;
    private EditText Q3;
    private EditText Q4;
    private EditText Q5;
    private Button next;
    private FirebaseAuth mAuth;
    private FirebaseUser details;
    private FirebaseFirestore fstore;
    private  String userDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Q1=(EditText)findViewById(R.id.q1);
        Q2=(EditText)findViewById(R.id.q2);
        Q3=(EditText)findViewById(R.id.q3);
        Q4=(EditText)findViewById(R.id.q4);
        Q5=(EditText)findViewById(R.id.q5);

        next=(Button) findViewById(R.id.btn);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        FirebaseUser answer = mAuth.getCurrentUser();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String A1 = Q1.getText().toString();
                String A2 = Q2.getText().toString();
                String A3 = Q3.getText().toString();
                String A4 = Q4.getText().toString();
                String A5 = Q5.getText().toString();


                userDetails = mAuth.getCurrentUser().getUid();

                DocumentReference doc = fstore.collection("Details").document(userDetails);
                Map<String,Object> Detail = new HashMap<>();

                Detail.put("When was the last time you smoked?", A1);
                Detail.put("How many packs of cigarettes do you purchase everyday?", A2);
                Detail.put("How many cigarettes do you smoke in a day?", A3);
                Detail.put("How old were you when you smoked for the first time?", A4);
                Detail.put("When do you feel like smoking?", A5);

                doc.set(Detail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UserDetails.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent intent = new Intent(UserDetails.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
