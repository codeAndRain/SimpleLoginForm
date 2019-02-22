package com.training.simpleloginform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Assignment add validation to edit text fields
 * <p>
 * if an edit text is empty, show a toast that says "edit text cannot be empty", where edit text can be username or password
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private AutoCompleteTextView usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private TextView usernameDetailsTextView;
    private TextView passwordDetailsTextView;
    private Button resetButton;

    List<String> names = new ArrayList<>();
    Set<String> namesList = new HashSet<>();


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


            names.add("Desmond");
            names.add("Dean");
            names.add("Iliana");
            names.add("Sulekha");

            usernameEditText.addTextChangedListener(this);
            usernameEditText.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, names));

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

                names.add(username);
                namesList.addAll(names);
                names.clear();
                names.addAll(namesList);

                break;
            case R.id.reset_button:
                setResetButton();
                break;
        }
    }

    public void setResetButton() {
        usernameEditText.setText("");
        passwordEditText.setText("");
        usernameDetailsTextView.setText("");
        passwordDetailsTextView.setText("");

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        usernameEditText.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, names));

    }

    @Override
    public void afterTextChanged(Editable s) {


    }
}
