package com.training.simpleloginform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Assignment add validation to edit text fields
 *
 * if an edit text is empty, show a toast that says "edit text cannot be empty", where edit text can be username or password
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private TextView usernameDetailsTextView;
    private TextView passwordDetailsTextView;
    private Button resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.user_name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        usernameDetailsTextView = findViewById(R.id.username_details_textview);
        passwordDetailsTextView = findViewById(R.id.password_details_textview);
        submitButton = findViewById(R.id.submit_button);
        resetButton = findViewById(R.id.reset_button);

        submitButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit_button:
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                usernameDetailsTextView.setText(username);
                passwordDetailsTextView.setText(password);
                break;
            case R.id.reset_button:
                usernameEditText.setText("");
                passwordEditText.setText("");
                break;
        }
    }
}
