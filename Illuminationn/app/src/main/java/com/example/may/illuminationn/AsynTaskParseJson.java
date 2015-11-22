package com.example.may.illuminationn;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Timothy on 2015-11-22.
 */

// you can make this class as another java file so it will be separated from your main activity.
public class AsynTaskParseJson extends AsyncTask<String, String, String> {

    final String TAG = "AsyncTaskParseJson.java";

    // set your json string url here
    String yourJsonStringUrl = "http://timothylock.ca/data.json";

    // contacts JSONArray
    JSONArray dataJsonArr = null;

    @Override
    protected void onPreExecute() {}

    @Override
    protected String doInBackground(String... arg0) {

        try {

            // instantiate our json parser
            JsonParser jParser = new JsonParser();

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);
            Connected.thing = (json.get("data").toString());
            Connected.time = (json.get("time").toString());
            return (json.get("data").toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {}
}