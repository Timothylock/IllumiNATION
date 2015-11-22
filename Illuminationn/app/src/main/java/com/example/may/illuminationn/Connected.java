package com.example.may.illuminationn;

import android.app.ActionBar;
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

public class Connected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_connected);
        getWindow().getDecorView().setBackgroundColor(1762331);

        while (true){
            System.out.println("bam bam");
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

    private InputStream getStream(String url) {
        try {
            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            urlConnection.setConnectTimeout(1000);
            return urlConnection.getInputStream();
        } catch (Exception ex) {
            return null;
        }
    }
    // TODO
    public int getColor(int color){
        return color;
    }
}
