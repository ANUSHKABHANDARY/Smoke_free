package com.example.smoke_login_firebase;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

//import java.lang.ref.Reference;

public class GraphPage extends AppCompatActivity {

    private TextView day;
    private ProgressBar progressBar;
    private EditText smokefreesince;
    private EditText moneysaved;

   // private FirebaseDatabase SmokeFree;
    //private DatabaseReference reference;
    //private FirebaseDatabase MoneySaved;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_page);


        day = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        smokefreesince = findViewById(R.id.editTextTextPersonName);
        moneysaved = findViewById(R.id.editTextTextPersonName2);


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