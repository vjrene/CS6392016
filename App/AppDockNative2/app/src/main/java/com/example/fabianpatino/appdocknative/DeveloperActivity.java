package com.example.fabianpatino.appdocknative;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.net.*;
import android.content.*;

public class DeveloperActivity extends AppCompatActivity {


    public void goHome (View view) {
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToStore (View view) {

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
        ComponentName comp = new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity"); // package name and activity
        launchIntent.setComponent(comp);
        launchIntent.setData(Uri.parse("market://details?id=com.okb.crossybricks&hl=en"));

        startActivity(launchIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void goToEdDev(View view) {
        final Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);
    }
}
