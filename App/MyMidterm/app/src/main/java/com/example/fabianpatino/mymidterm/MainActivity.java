package com.example.fabianpatino.mymidterm;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        EditText dollars;
        TextView francs;
        Button convert;

        @Override

        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            dollars = (EditText) findViewById(R.id.dollars);
            convert = (Button) findViewById(R.id.convert);
            francs = (TextView) findViewById(R.id.francs);
            convert.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
                currencyConvert();
            }

        protected void currencyConvert() {
            String val = dollars.getText().toString();
            double convertFranc= Double.parseDouble(val)*586.84;
            francs.setText(Double.toString(convertFranc));

        }

    }
