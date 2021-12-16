package com.example.smoke_login_firebase;

import androidx.appcompat.app.AppCompatActivity;

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

public class Rate extends AppCompatActivity {

    EditText namedata, messagedata;
    Button send;
    private FirebaseAuth mAuth;
    private FirebaseUser FeedBack;
    private FirebaseFirestore fstore;
    private  String userFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        //database=FirebaseFirestore.getInstance();
        namedata = findViewById(R.id.namedata);
        messagedata = findViewById(R.id.messagedata);

        send = findViewById(R.id.btn_send);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        FirebaseUser answer = mAuth.getCurrentUser();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                final String name = namedata.getText().toString();
                final String message = messagedata.getText().toString();


                if (name.isEmpty()) {
                    namedata.setError("This is an required field");
                    send.setEnabled(false);
                }

                if (message.isEmpty()) {
                    messagedata.setError("This is an required field");
                    send.setEnabled(false);
                }

                userFeedback = mAuth.getCurrentUser().getUid();

                DocumentReference doc = fstore.collection("Feedback").document(userFeedback);
                Map<String,Object> Feedback = new HashMap<>();

                Feedback.put("name",name);
                Feedback.put("message",message);

                doc.set(Feedback).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Rate.this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}
