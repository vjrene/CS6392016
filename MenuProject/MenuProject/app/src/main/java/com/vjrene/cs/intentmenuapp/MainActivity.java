package com.vjrene.cs.intentmenuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.content.*;
import android.net.*;



public class MainActivity extends AppCompatActivity {


    public void sendTheText(View view) {

        final Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + Uri.encode("13472782863")));
        intent.putExtra("sms_body", "Hello, Vanessa Rene!");
        startActivity(intent);
    }

    public void makeCall(View view) {
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + Uri.encode("13472782863")));
        startActivity(intent);
    }

    public void goToBrowser(View view) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.vanessarenephotography.tumblr.com/"));
        startActivity(intent);
    }


    public void goToMap(View view)
    {
        String geoUri = String.format("geo:40.655643, -73.945761");
        Uri geo = Uri.parse(geoUri);
        final Intent intent = new Intent (Intent.ACTION_VIEW, geo);
        startActivity(intent);
    }

    public void share(View view)
    {
        final Intent intent = new Intent (Intent.ACTION_SEND);
        String title = getResources().getString(R.string.chooser_title);
        Intent chooser = Intent.createChooser(intent, title);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "CS639");
        intent.putExtra(Intent.EXTRA_TEXT,"Join CS639");
        startActivity(Intent.createChooser(intent, "Share the love :)"));
    }

    public void newAct(View view)
    {
        final Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You just hit this button :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_help: //if the user chose help
                Intent i = new Intent(this,HelpActivity.class);
                this.startActivity(i);
                return true;

            case R.id.action_settings:
                Intent a = new Intent(this,SetActivity.class);
                this.startActivity(a);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
