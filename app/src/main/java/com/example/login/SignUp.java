package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {

    TextInputEditText textInputEditTextFullName, textInputEditTextUsername, textInputEditTextEmail, textInputEditTextPassword;

    Button buttonSignUp;
    TextView textViewLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditTextFullName = findViewById(R.id.fullname);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextEmail = findViewById(R.id.email);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewLogin = findViewById(R.id.loginText);
        progressBar = findViewById(R.id.progress);

        buttonSignUp.setOnClickListener(v -> {

            String fullname, username, password, email;
            fullname = String.valueOf(textInputEditTextFullName.getText());
            username = String.valueOf(textInputEditTextUsername.getText());
            password = String.valueOf(textInputEditTextPassword.getText());
            email = String.valueOf(textInputEditTextEmail.getText());

            if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {

                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();

                handler.post(() -> {

                    //Starting Write and Read data with URL
                    //Creating array for parameters
                    String[] field = new String[4];
                    field[0] = "fullname";
                    field[1] = "username";
                    field[2] = "password";
                    field[3] = "email";

                    //Creating array for data
                    String[] data = new String[4];
                    data[0] = fullname;
                    data[1] = username;
                    data[2] = password;
                    data[3] = email;

                    PutData putData = new PutData(new ArchanaErpApiUtils().getSignUpApiUrl(), "POST", field, data);

                    if (putData.startPut()) {

                        if (putData.onComplete()) {

                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();

                            if (result.equals("Sign Up Success")) {

                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Signin.class);
                                startActivity(intent);
                                finish();

                            } else {

                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                            //End ProgressBar (Set visibility to GONE)
                        }
                    }
                    //End Write and Read data with URL
                });
            } else {

                Toast.makeText(getApplicationContext(), "all fileds are Requred", Toast.LENGTH_SHORT).show();
            }
        });
        //Start ProgressBar first (Set visibility VISIBLE)
    }
}
