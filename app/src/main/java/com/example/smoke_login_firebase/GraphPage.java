package com.example.smoke_login_firebase;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

//import java.lang.ref.Reference;

public class GraphPage extends AppCompatActivity {

    private TextView Number;
    private ProgressBar progressBar;
    private TextView Spent;
    private Button start;
    private Chronometer chronometer;

   // private FirebaseDatabase SmokeFree;
    //private DatabaseReference reference;
    //private FirebaseDatabase MoneySaved;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_page);


        Number = findViewById(R.id.num);
        progressBar = findViewById(R.id.progressBar);
        Spent = findViewById(R.id.saved);
        start = findViewById(R.id.shuru);
        chronometer = findViewById(R.id.chronometer);

        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setBase(SystemClock.elapsedRealtime());
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });

        Spent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GraphPage.this, HomePage.class);
                startActivityForResult(intent, 2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String returnString = data.getStringExtra("result");
                Spent.setText(returnString);
            }
        }


      //  smokefreesince.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View view) {
           //     SmokeFree = FirebaseDatabase.getInstance();
            //    reference = SmokeFree.getReference("Smoke Free Since");


            //    reference.setValue("19 days ");
         //   }


      //  });



    }

}