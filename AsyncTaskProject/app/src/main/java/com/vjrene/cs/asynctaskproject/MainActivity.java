package com.vjrene.cs.asynctaskproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.content.*;
import android.graphics.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    //elements before they're taken from fragment
    ImageView imgV;
    Button btn;
    String imgURL = "https://raw.githubusercontent.com/vjrene/CS6392016/master/AsyncTask/brooklyn.jpg";

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //elements grabbed from fragment
        imgV = (ImageView) findViewById(R.id.imageView);
        btn = (Button) findViewById(R.id.button);

        //button onclick
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new downloadImage().execute(imgURL);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //AsyncTask completed here
    private class downloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... params){
            Bitmap finalImage;
            Bitmap bitmap = null;
            try {
                URL url = new URL(params[0]);
                InputStream is = url.openConnection().getInputStream();
                finalImage = BitmapFactory.decodeStream(is);

                return finalImage;
            } catch (Exception e) {

                Context context = getApplicationContext();
                CharSequence text = "Could not load image. Check connection.";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imgV.setImageBitmap(bitmap);
        }
    }
}
