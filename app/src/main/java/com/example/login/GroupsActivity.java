package com.example.login;

import android.os.Bundle;
import android.view.View;

import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

import ndk.utils_android1.ActivityUtils1;
import ndk.utils_android1.DateUtils1;
import ndk.utils_android14.HttpApiSelectTaskWrapper14;
import ndk.utils_android16.SharedPreferenceUtils16;
import ndk.utils_android19.ExceptionUtils19;

public class GroupsActivity extends ArchanaErpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        RecyclerView recyclerViewGroups = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewGroups.setLayoutManager(linearLayoutManager);
        recyclerViewGroups.setHasFixedSize(true);

        ArrayList<String> groups = new ArrayList<>();

        HttpApiSelectTaskWrapper14.executeNonSplashForegroundPostWithParametersAndStatusCheckOnAsyncResponseJsonArrayFirstElement(new ArchanaErpApiUtils().getGroupsApiUrl(), new Pair[]{}, currentActivityContext, (View) findViewById(R.id.progressBar), recyclerViewGroups, applicationSpecification.applicationName, jsonArray -> {

            try {

                for (int i = 1; i < jsonArray.length(); i++) {

                    groups.add(jsonArray.getJSONObject(i).getString("cag_name"));
                }

            } catch (JSONException jsonException) {

                ExceptionUtils19.handleExceptionOnGui(currentApplicationContext, applicationSpecification.applicationName, jsonException);
            }
        });

        GroupsRecyclerViewAdaptor groupsRecyclerViewAdaptor = new GroupsRecyclerViewAdaptor(groups);
        groupsRecyclerViewAdaptor.setOnGroupNameClickListener((view, groupName) -> {

            applicationLogUtils.debugOnGui("Group : " + groupName);
            SharedPreferenceUtils16.commitSharedPreferences(applicationSharedPreferences, new Pair[]{new Pair<>("selectedGroup", groupName)});
            ActivityUtils1.startActivityForClass(currentActivityContext, MainActivity.class);

        });
        recyclerViewGroups.setAdapter(groupsRecyclerViewAdaptor);

        SharedPreferenceUtils16.isFirstRun(applicationSharedPreferences, () -> SharedPreferenceUtils16.commitSharedPreferences(applicationSharedPreferences, new Pair[]{new Pair<>("lastTransactionDate", DateUtils1.getCurrentDateStringInNormalFormat())}));
    }
}
