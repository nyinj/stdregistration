package com.example.loginsemregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        TextView firstnameTextView = findViewById(R.id.i_fn_text);
        TextView lastnameTextView = findViewById(R.id.i_ln_text);
        TextView dobTextView = findViewById(R.id.i_dob_text);
        TextView stdnoTextView = findViewById(R.id.i_stdno_text);
        TextView emailTextView = findViewById(R.id.i_email_text);
        TextView yndTextView = findViewById(R.id.i_ynd_text);

        // Displaying the information
        firstnameTextView.setText(GlobalVariable.first_name);
        lastnameTextView.setText(GlobalVariable.last_name);
        dobTextView.setText(GlobalVariable.dob);
        stdnoTextView.setText(GlobalVariable.std_no);
        emailTextView.setText(GlobalVariable.email);
        yndTextView.setText(GlobalVariable.ynd);

        Button confirmButton = findViewById(R.id.confirmbtn);
        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Return to MainActivity to clear the form and start new registration
                Intent intent = new Intent(Information.this, MainActivity.class);
                startActivity(intent);
                finish(); // Ensure the user cannot navigate back to information activity
            }
        });

        Button backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Return to the registration form (MainActivity)
            }
        });
    }
}
