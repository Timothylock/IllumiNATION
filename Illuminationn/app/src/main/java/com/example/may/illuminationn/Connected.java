package com.example.may.illuminationn;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

public class Connected extends AppCompatActivity {
    public static String thing;
    public String row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_connected);

        Intent intent = getIntent();
        row = intent.getStringExtra("RowNumber");
        TextView t = (TextView)findViewById(R.id.textView);

        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#000000"));

        getInstructions();
        try {
            JSONObject responseJSON = new JSONObject(thing);
            t.setText(responseJSON.get("r" + row).toString());

        } catch (JSONException e) {
            t.setText("Could not obtain data. Wrong row?");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_connected, menu);
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



    public void setColor(View view) {
        //String color = getColor(row);
        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#008000"));
    }

    // check from the file
    public void getInstructions(){
        new AsynTaskParseJson().execute();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
