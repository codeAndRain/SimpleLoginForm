package com.training.simpleloginform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    private TextView usernameDetailsTextView;
    private TextView passwordDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        usernameDetailsTextView = findViewById(R.id.username_details_textview);
        passwordDetailsTextView = findViewById(R.id.password_details_textview);


        usernameDetailsTextView.setText(getIntent().getStringExtra("username"));
        passwordDetailsTextView.setText(getIntent().getStringExtra("password"));


    }
}

