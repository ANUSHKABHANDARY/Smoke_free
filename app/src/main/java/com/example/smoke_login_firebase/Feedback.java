package com.example.smoke_login_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feedback extends AppCompatActivity {

    private Button Give;
    private Button Feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Give = (Button) findViewById(R.id.bt1);
        Feedback = (Button) findViewById(R.id.bt2);

        Give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Download this application now:https://play.google.com/store/apps/details?id=com.EAGINsoftware.dejaloYa&hl=en";
                String sharesub = "Smoke Free App";

                shareIntent.putExtra(Intent.EXTRA_SUBJECT, sharesub);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Share Using"));
            }
        });

        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Feedback.this, Rate.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
