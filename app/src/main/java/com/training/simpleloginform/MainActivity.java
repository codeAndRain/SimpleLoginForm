package com.training.simpleloginform;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Assignment add validation to edit text fields
 * <p>
 * if an edit text is empty, show a toast that says "edit text cannot be empty", where edit text can be username or password
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    public static final String APP_SHARED_PREF = "APP_PREF";
    public static final String PREF_KEY_USERNAME = "USER_NAME";
    public static final String PREF_KEY_PWD = "PASSWORD";
    public static final String PREF_KEY_USER_LOGGED_IN = "LOGGED_IN";


    private AutoCompleteTextView usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private Button resetButton;
    private String prefUserName;
    private String prefPwd;
    private boolean prefIsAlreadyLoggedIn;

    Names names = new Names();

    List<String> namesList = new ArrayList<>();
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.user_name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        submitButton = findViewById(R.id.submit_button);
        resetButton = findViewById(R.id.reset_button);

        namesList.addAll(names.getNames());

        usernameEditText.addTextChangedListener(this);
        usernameEditText.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, namesList));

        submitButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(APP_SHARED_PREF, Context.MODE_PRIVATE);
        prefUserName = sharedPreferences.getString(PREF_KEY_USERNAME, "");
        prefPwd = sharedPreferences.getString(PREF_KEY_PWD, "");
        prefIsAlreadyLoggedIn = sharedPreferences.getBoolean(PREF_KEY_USER_LOGGED_IN, false);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit_button:
                String userName = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (!userName.isEmpty() && !password.isEmpty()) {
                    if (prefIsAlreadyLoggedIn) {
                        if (userName.equals(prefUserName) && password.equals(prefPwd)) {
                            startSecondActivity(userName, password);
                        } else {
                            Toast.makeText(this, "incorrect username or password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        if (!namesList.contains(userName)) {
                            namesList.add(userName);
                        }
                        saveUserName(userName, password);
                        startSecondActivity(userName, password);
                    }
                }
                break;
            case R.id.reset_button:
                setResetButton();
                break;
        }

    }

    private void saveUserName(String userName, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_KEY_USERNAME, userName);
        editor.putString(PREF_KEY_PWD, password);
        editor.putBoolean(PREF_KEY_USER_LOGGED_IN, true);
        editor.apply();
    }

    private void startSecondActivity(String userName, String password) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("username", userName);
        intent.putExtra("password", password);
        startActivity(intent);
    }

    public void setResetButton() {
        usernameEditText.setText("");
        passwordEditText.setText("");

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        usernameEditText.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, namesList));

    }

    @Override
    public void afterTextChanged(Editable s) {


    }
}
