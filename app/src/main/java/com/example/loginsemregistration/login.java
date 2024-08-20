package com.example.loginsemregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class login extends AppCompatActivity {

    private static final String VALID_STDNO = "02220158";
    private static final String VALID_PASSWORD = "Bhutan@123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText stdTextField = findViewById(R.id.stdno_login);
        EditText passwordTextField = findViewById(R.id.password_login);
        Button loginButton = findViewById(R.id.login_btn);
        FloatingActionButton fabInfo = findViewById(R.id.fab_info);

        // Handle login button click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentNumber = stdTextField.getText().toString();
                String password = passwordTextField.getText().toString();

                if (studentNumber.equals(VALID_STDNO) && password.equals(VALID_PASSWORD)) {
                    Toast.makeText(login.this, "Login Success", Toast.LENGTH_SHORT).show();
                    openRegistration();
                } else {
                    Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle FAB click to show information
        fabInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(login.this)
                        .setTitle("App Information")
                        .setMessage("This app allows students to log in with their student number and password. If you haven't registered, please visit the registration page.")
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
            }
        });
    }

    private void openRegistration() {
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
