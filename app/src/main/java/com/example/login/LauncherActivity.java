package com.example.login;

import android.os.Bundle;
import android.os.Handler;

import ndk.utils_android14.ActivityUtils14;

public class LauncherActivity extends ArchanaErpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Handler handler = new Handler();
        handler.postDelayed(() -> {

//            ActivityUtils14.startActivityForClassWithFinish(currentActivityContext, MainActivity.class);
//            ActivityUtils14.startActivityForClassWithFinish(currentActivityContext, GroupsActivity.class);
            ActivityUtils14.startActivityForClassWithFinish(currentActivityContext, LoginActivity.class);

        }, 3000);
    }
}