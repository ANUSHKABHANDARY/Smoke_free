package com.example.smoke_login_firebase;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {

    private Button button;
    private TextView textview;
    private ImageView increase;
    private ImageView decrease;
    private EditText display;
    private int minteger;
    private ImageView graph;
    private Button graphbutton;
    private Button Healthbutton;
    private Button Profilebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        button = findViewById(R.id.button);
        textview = findViewById(R.id.textView6);
        increase = findViewById(R.id.imageView);
        decrease = findViewById(R.id.imageView2);
        display = findViewById(R.id.editTextTextPersonName2);
        graph = findViewById(R.id.imageView3);
        graphbutton=findViewById(R.id.button2);
        Healthbutton=findViewById(R.id.button3);
        Profilebutton = findViewById(R.id.button4);

       graphbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this,GraphPage.class);
               startActivity(intent);
            }
       });

       Healthbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(HomePage.this,Health.class);
               startActivity(intent);
           }
       });

        Profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this,Profile.class);
                startActivity(intent);
            }
        });




        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (minteger > 0) {
                    minteger = minteger - 1;
                    displayInteger(minteger);

                } else {
                    Toast.makeText(HomePage.this, "Cannot decrease anymore!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = display.getText().toString();
                int a = Integer.parseInt(s);
                Toast.makeText(HomePage.this, "Ouch", Toast.LENGTH_SHORT).show();
                textview.setText(" Total " + a);
            }
        });
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                minteger = minteger + 1;
                displayInteger(minteger);
            }
        });


    }


    private void displayInteger(int number) {

        display.setText("" + number);

    }

}
