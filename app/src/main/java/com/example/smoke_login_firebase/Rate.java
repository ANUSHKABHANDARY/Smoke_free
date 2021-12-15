package com.example.smoke_login_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class Rate extends AppCompatActivity {

    EditText namedata, emaildata, messagedata;
    Button send, details;
    //FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        //database=FirebaseFirestore.getInstance();
        namedata = findViewById(R.id.namedata);
        emaildata = findViewById(R.id.emaildata);
        messagedata = findViewById(R.id.messagedata);

        send = findViewById(R.id.btn_send);
        details = findViewById(R.id.btn_details);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                details.setEnabled(true);
                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();


                if (name.isEmpty()) {
                    namedata.setError("This is an required field");
                    send.setEnabled(false);
                }

                if (email.isEmpty()) {
                    emaildata.setError("This is an required field");
                    send.setEnabled(false);
                }

                if (message.isEmpty()) {
                    messagedata.setError("This is an required field");
                    send.setEnabled(false);
                }

                HashMap<String,Object> feedback=new HashMap<>();
                feedback.put("email",email);
                feedback.put("name",name);
                feedback.put("message",message);


//                database.collection("Feedback").document(email)
//                        .set(feedback)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if(task.isSuccessful()){
//                                    Toast.makeText(feedbackv2.this, "Data Entered", Toast.LENGTH_SHORT).show();
//
//
//                                } else{
//                                    Toast.makeText(feedbackv2.this, "Data Not Entered", Toast.LENGTH_SHORT).show();
//
//
//                                }
                            }
                        });

            }
    }
