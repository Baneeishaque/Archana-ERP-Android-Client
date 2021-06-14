package com.example.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SettingsActivity extends AppCompatActivity {

    CardView branch;
    CardView year;
    CardView changepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        branch = findViewById(R.id.branch);
        year = findViewById(R.id.profile);
        changepassword = findViewById(R.id.changepassword);

        branch.setOnClickListener(v -> startActivity(new Intent(SettingsActivity.this, BranchActivity.class)));

        year.setOnClickListener(v -> startActivity(new Intent(SettingsActivity.this, YearActivity.class)));

        changepassword.setOnClickListener(v -> startActivity(new Intent(SettingsActivity.this, ChangepasswordActivity.class)));
    }
}
