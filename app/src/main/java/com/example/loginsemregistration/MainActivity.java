package com.example.loginsemregistration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EditText first_name = findViewById(R.id.firstname_TextField);
        EditText last_name = findViewById(R.id.lastname_textfield);
        EditText dob = findViewById(R.id.dob_textfield);
        EditText stdno = findViewById(R.id.stdno_textfield);
        EditText email = findViewById(R.id.email_textfield);
        EditText ynd = findViewById(R.id.ynd_textfield);

        Button submit = findViewById(R.id.submit_btn);
        Button logout = findViewById(R.id.logout_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save input values to GlobalVariable
                GlobalVariable.first_name = first_name.getText().toString();
                GlobalVariable.last_name = last_name.getText().toString();
                GlobalVariable.dob = dob.getText().toString();
                GlobalVariable.std_no = stdno.getText().toString();
                GlobalVariable.email = email.getText().toString();
                GlobalVariable.ynd = ynd.getText().toString();

                // Open the Information Activity
                Intent goToInformation = new Intent(MainActivity.this, Information.class);
                startActivity(goToInformation);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear global variables if necessary
                clearGlobalVariables();

                // Redirect to login activity
                Intent goToLogin = new Intent(MainActivity.this, login.class);
                startActivity(goToLogin);
                finish(); // Ensure that user cannot navigate back to MainActivity using back button
            }
        });
    }

    private void clearGlobalVariables() {
        GlobalVariable.first_name = "";
        GlobalVariable.last_name = "";
        GlobalVariable.dob = "";
        GlobalVariable.std_no = "";
        GlobalVariable.email = "";
        GlobalVariable.ynd = "";
    }





}
