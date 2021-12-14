package com.example.smoke_login_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserDetails extends AppCompatActivity {
    private EditText Q1;
    private EditText Q2;
    private EditText Q3;
    private EditText Q4;
    private EditText Q5;
    private Button next;

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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetails.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
