package com.training.simpleloginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Assignment add validation to edit text fields
 *
 * if an edit text is empty, show a toast that says "edit text cannot be empty", where edit text can be username or password
 *
 */
public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.user_name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        submitButton = findViewById(R.id.submit_button);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Toast.makeText(MainActivity.this, username + ", " + password, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
