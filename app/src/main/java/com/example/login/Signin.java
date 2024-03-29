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

public class Signin extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textViewSignUp;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewSignUp = findViewById(R.id.signUpText);
        progressBar = findViewById(R.id.progress);

        buttonLogin.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

//            String username, password;
//            username = String.valueOf(textInputEditTextUsername.getText());
//            password = String.valueOf(textInputEditTextPassword.getText());
//
//            if (!username.equals("") && !password.equals("")) {
//
//                progressBar.setVisibility(View.VISIBLE);
//                Handler handler = new Handler();
//
//                handler.post(() -> {
//
//                    //Starting Write and Read data with URL
//                    //Creating array for parameters
//                    String[] field = new String[2];
//                    field[0] = "username";
//                    field[1] = "password";
//                    //Creating array for data
//                    String[] data = new String[2];
//                    data[0] = username;
//                    data[1] = password;
//                    PutData putData = new PutData(new ArchanaErpApiUtils().getLoginApiUrl(), "POST", field, data);
//
//                    if (putData.startPut()) {
//
//                        if (putData.onComplete()) {
//
//                            progressBar.setVisibility(View.GONE);
//                            String result = putData.getResult();
//
//                            if (result.equals("Login Success")) {
//
//                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            } else {
//
//                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                            }
//                            //End ProgressBar (Set visibility to GONE)
//                        }
//                    }
//                    //End Write and Read data with URL
//                });
//            } else {
//
//                Toast.makeText(getApplicationContext(), "all fields are Required", Toast.LENGTH_SHORT).show();
//            }
        });
    }
}
