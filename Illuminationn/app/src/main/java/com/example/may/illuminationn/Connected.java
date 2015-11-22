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
        getWindow().getDecorView().setBackgroundColor(Color.parseColor(getColor(row)));

//        while (true){
//            new AsynTaskParseJson().execute();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            System.out.println("===========================");
//
//            System.out.println(thing);
//            try {
//                Thread.sleep(100000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }


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
        String color = getColor(row);
        view.setBackgroundColor(Color.parseColor(color));
    }

    // check from the file, se
    public String getColor(String rowNum){
        new AsynTaskParseJson().execute();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // this line breaks the code, do not include.
        //   System.out.println(thing);

        // assume AsynTaskParseJson works, the program can now execute as expected
        // and thing should have already been parsed

        String color = null;
        //TODO
        // go through the parsed map, get corresponding color according to rowNum.
        
        return color;
    }
}
