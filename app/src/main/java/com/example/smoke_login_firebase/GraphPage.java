package com.example.smoke_login_firebase;



import androidx.appcompat.app.AppCompatActivity;

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
    private EditText moneysaved;
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
        moneysaved = findViewById(R.id.editTextTextPersonName2);
        start = findViewById(R.id.shuru);
        chronometer = findViewById(R.id.chronometer);

        chronometer.setBase(SystemClock.elapsedRealtime());

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });


        // perform click  event on restart button to set the base time on chronometer
//        restart.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//                chronometer.setBase(SystemClock.elapsedRealtime());
//            }
//        });


      //  smokefreesince.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View view) {
           //     SmokeFree = FirebaseDatabase.getInstance();
            //    reference = SmokeFree.getReference("Smoke Free Since");


            //    reference.setValue("19 days ");
         //   }


      //  });


       // moneysaved.setOnClickListener(new View.OnClickListener() {
          //  @Override
        //    public void onClick(View view) {
           //     MoneySaved = FirebaseDatabase.getInstance();
            //    reference = MoneySaved.getReference("Money Saved");
            //    reference.setValue("100 RS.");






        //    }
       // });


    }

}