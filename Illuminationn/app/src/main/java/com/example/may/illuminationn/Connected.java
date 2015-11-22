package com.example.may.illuminationn;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    public static String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_connected);

        Intent intent = getIntent();
        row = intent.getStringExtra("RowNumber");

        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#000000"));

        Thread thread = new Thread() {
            public void wait(int ms){
                try {
                    Thread.sleep(ms);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void run() {
                //Tim Variables
                String colour;
                int delay;
                int duration;
                String[] items;

                getInstructions();
                try {
                    JSONObject responseJSON = new JSONObject(thing);
                    System.out.println("==================");
                    JSONArray r = responseJSON.getJSONArray("r" + row);
                    System.out.println(time);
                    long start = Long.parseLong(time);
                    System.out.println("==================");
                    long current = System.currentTimeMillis();
                    System.out.println(start - current);
                    try {
                        Thread.sleep(start - current);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (int i = 0; i < r.length(); i++) {
                        // Get Data
                        items = r.get(i).toString().split(",");
                        colour = r.getJSONArray(i).toString().substring(2, 9);
                        delay = Integer.parseInt(items[1].toString());
                        duration = Integer.parseInt(items[2].toString().substring(0, items[2].toString().length() - 1));

                        // Display It
                        wait(1000 * delay);
                        changeCol(colour);
                        wait(1000 * duration);
                        changeCol("#000000");

                    }
                } catch (JSONException e) {
                }
            }
        };

        thread.start();
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

    public void changeCol(final String col){
        runOnUiThread(new Runnable() {
            public void run() {
                getWindow().getDecorView().setBackgroundColor(Color.parseColor(col));
            }
        });
    }

    // check from the file
    public void getInstructions(){
        new AsynTaskParseJson().execute();
        wait(1000);
    }

    // Sleep
    public void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}

