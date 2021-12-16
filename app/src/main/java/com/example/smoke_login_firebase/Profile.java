package com.example.smoke_login_firebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Profile extends AppCompatActivity {

    private ImageView Photo;
    private ImageView Iname;
    private ImageView Iage;
    private ImageView Iemail;
    private ImageView Ipass;
    private TextView Tname;
    private TextView Tage;
    private TextView Temail;
    private TextView Tpassword;
    private Button Feed;
    private Button Logout;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseFirestore fstore;
    private  String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Photo = (ImageView) findViewById(R.id.photo);
        Iname= (ImageView) findViewById(R.id.i_name);
        Iage= (ImageView) findViewById(R.id.i_age);
        Iemail= (ImageView) findViewById(R.id.i_email);
        Ipass= (ImageView) findViewById(R.id.i_pass);
        Tname = (TextView) findViewById(R.id.e_name);
        Tage = (TextView) findViewById(R.id.e_age);
        Temail = (TextView) findViewById(R.id.e_email);
        Tpassword = (TextView) findViewById(R.id.e_pass);
        Feed = (Button) findViewById(R.id.button);
        Logout = (Button) findViewById(R.id.out);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = mAuth.getCurrentUser().getUid();

        Feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Feedback.class);
                startActivity(intent);
                finish();
            }
        });

        DocumentReference doc = fstore.collection("user").document(userID);
        doc.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                Tname.setText(value.getString("FullName"));
                Tage.setText(value.getString("Age"));
                Temail.setText(value.getString("Mail"));
                Tpassword.setText(value.getString("Pass"));

            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
            }
        });
    }

}