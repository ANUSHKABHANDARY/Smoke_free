package com.example.smoke_login_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Profile extends AppCompatActivity {

    private ImageView Photo;
    private ImageView Iname;
    private ImageView Iage;
    private ImageView Igender;
    private ImageView Iemail;
    private ImageView Ipass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Photo = (ImageView) findViewById(R.id.photo);
        Iname= (ImageView) findViewById(R.id.i_name);
        Iage= (ImageView) findViewById(R.id.i_age);
        Igender= (ImageView) findViewById(R.id.i_gender);
        Iemail= (ImageView) findViewById(R.id.i_email);
        Ipass= (ImageView) findViewById(R.id.i_pass);



    }
}