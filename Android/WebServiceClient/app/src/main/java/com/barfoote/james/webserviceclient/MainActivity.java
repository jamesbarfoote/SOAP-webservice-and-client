package com.barfoote.james.webserviceclient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Button convert = (Button) findViewById(R.id.convertButton);
        convert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Get the values from the text boxes
                TextView countryFrom = (TextView) findViewById(R.id.countryFromText);
                TextView countryTo = (TextView) findViewById(R.id.countryToText);
                TextView fromRate = (TextView) findViewById(R.id.fromRateText);
                TextView toRate = (TextView) findViewById(R.id.toRateText);
                TextView amountToConvert = (TextView) findViewById(R.id.amountToConvert);
                TextView convertedAmount = (TextView) findViewById(R.id.amountConverted);

                //Call the WebService activity
                WebServiceActivity ws = new WebServiceActivity();
                double toConvertAmount = Double.parseDouble(amountToConvert.getText().toString());
                ws.connect(countryFrom.getText().toString(), countryTo.getText().toString(), fromRate.getText().toString(), toRate.getText().toString(), toConvertAmount);
                convertedAmount.setText(ws.getConvertedAmount());
            }
        });

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
}
