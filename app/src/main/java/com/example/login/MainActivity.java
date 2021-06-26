package com.example.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends ArchanaErpActivity {

    CardView transaction;
    CardView profile;
    CardView report;
    CardView meeting;
    CardView settings;
    CardView help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(applicationSharedPreferences.getString("selectedGroup","Unknown") +" Home");

        transaction = findViewById(R.id.transaction);
        profile = findViewById(R.id.profile);
        report = findViewById(R.id.report);
        meeting = findViewById(R.id.meeting);
        settings = findViewById(R.id.settings);
        help = findViewById(R.id.help);

        transaction.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TransactionActivity.class)));

        profile.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));

        report.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ReportActivity.class)));

        meeting.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MeetingActivity.class)));

        settings.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SettingsActivity.class)));

        help.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HelpActivity.class)));
    }
}
