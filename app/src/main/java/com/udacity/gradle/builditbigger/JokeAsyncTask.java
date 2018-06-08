package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.jokeviewer.JokeViewerActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    private Context mContext;

    private String GOOGLE_ENGINE_URL = "http://10.0.2.2:8080/_ah/api/";

    public JokeAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        MyApi.Builder apiBuilder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(),
                null)
                .setRootUrl(GOOGLE_ENGINE_URL);

        MyApi myApi = apiBuilder.build();

        try {
            return myApi.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent intent = new Intent(mContext, JokeViewerActivity.class);
        intent.putExtra("JOKE", joke);
        mContext.startActivity(intent);
    }
}
