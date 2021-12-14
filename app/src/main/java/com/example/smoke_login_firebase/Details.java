package com.example.smoke_login_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.application.detail.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class Details extends AppCompatActivity {
    private EditText mlasttime, mpack, mday, mold, musuallysmoke;
    private  Button nextbtn;
   // DatabaseReference UsersdbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mlasttime = findViewById(R.id.lasttime);
        mpack = findViewById(R.id.pack);
        mday = findViewById(R.id.day);
        mold =findViewById(R.id.old);
        musuallysmoke = findViewById(R.id.usuallysmoke);
        nextbtn=findViewById(R.id.btn);

      //  UsersdbRef =FirebaseDatabase.getInstance("https://details-ba373-default-rtdb.firebaseio.com/").getReference().child("Users");

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertinfodata();
            }

        });
    }
    private void insertinfodata() {


        String dailycigarettes = mlasttime.getText().toString();
        String pack = mpack.getText().toString();
        String price = mday.getText().toString();
        String feel = mold.getText().toString();
        String today = musuallysmoke.getText().toString();

        Users users = new Users(dailycigarettes, pack, price, feel, today);

        //UsersdbRef.push().setValue(users);
        Toast.makeText(Details.this, "Data inserted", Toast.LENGTH_SHORT).show();

    }

}

