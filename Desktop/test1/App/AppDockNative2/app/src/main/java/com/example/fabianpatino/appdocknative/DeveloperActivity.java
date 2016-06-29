package com.example.fabianpatino.appdocknative;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.net.*;
import android.content.*;


/**
 * Created by fabianpatino on 6/25/16.
 */
public class DeveloperActivity extends AppCompatActivity {

    public void goHome (View view) {
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToEdDev(View view) {
        final Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}