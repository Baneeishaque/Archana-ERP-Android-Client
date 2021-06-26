package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.core.util.Pair;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ndk.utils_android1.ToastUtils1;
import ndk.utils_android14.ActivityUtils14;
import ndk.utils_android14.ButtonUtils14;
import ndk.utils_android14.HttpApiSelectTaskWrapper14;
import ndk.utils_android16.ValidationUtils16;
import ndk.utils_android19.ExceptionUtils19;

public class LoginActivity extends ArchanaErpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPasscode = findViewById(R.id.editTextPasscode);

        ButtonUtils14.associateClickAction(currentAppCompatActivity, R.id.buttonSignIn, v -> {

            ArrayList<org.javatuples.Pair<EditText, String>> editTextPairs = new ArrayList<>();
            editTextPairs.add(org.javatuples.Pair.with(editTextUsername, "Please Enter Username..."));
            editTextPairs.add(org.javatuples.Pair.with(editTextPasscode, "Please Enter Passcode..."));

            org.javatuples.Pair<Boolean, EditText> validationResult = ValidationUtils16.nonEmptyCheckEditTextPairs(editTextPairs);

            if (validationResult.getValue0()) {

                HttpApiSelectTaskWrapper14.executeNonSplashForegroundPostWithParametersAndWithoutStatusCheckOnAsyncResponseJsonArrayFirstElement(new ArchanaErpApiUtils().getLoginApiUrl(), new Pair[]{new Pair<>("user_name", editTextUsername.getText().toString()), new Pair<>("password", editTextPasscode.getText().toString())}, currentActivityContext, (View) findViewById(R.id.progressBar), (View) findViewById(R.id.constraintLayout), applicationSpecification.applicationName, jsonArray -> {

                    try {

                        JSONObject countJsonObject = jsonArray.getJSONObject(0);
                        if (countJsonObject.getString("count").equals("0")) {

                            ToastUtils1.longToast(currentApplicationContext, "Invalid User!...");

                        } else {

                            ActivityUtils14.startActivityForClassWithFinish(currentActivityContext, GroupsActivity.class);
                        }

                    } catch (JSONException jsonException) {

                        ExceptionUtils19.handleExceptionOnGui(currentApplicationContext, applicationSpecification.applicationName, jsonException);
                    }
                });

            } else {

                validationResult.getValue1().requestFocus();
            }
        });
    }
}
