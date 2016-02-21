package com.udacity.gradle.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.darkgeat.builditbigger.backend.jokesApi.JokesApi;
import com.udacity.gradle.listeners.OnJokeListener;

import java.io.IOException;

/**
 * Created by DarkGeat on 2/20/2016.
 */
public class JokeTask extends AsyncTask<Void,Void,Boolean> {
    private static JokesApi jokesAPI = null;
    private Context context;
    private String responce = null;
    private OnJokeListener listener = null;
    private ProgressDialog progressDialog = null;

    public JokeTask(){}

    public JokeTask(Context c){
        context = c;
        listener = (OnJokeListener)context;
        progressDialog = new ProgressDialog(context);
    }

    public JokeTask(Context c, @Nullable OnJokeListener l){
        context = c;
        progressDialog = new ProgressDialog(context);
        if (null != l) listener = l;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressDialog != null){
            progressDialog.setMessage("Loading Joke...");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        responce = null;
        if (jokesAPI == null){
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null);
            // options for running against local devappserver
            // - 10.0.2.2 is localhost's IP address in Android emulator
            // if using genymotion it seems to have the address of 10.0.3.2 instead of 10.0.2.2
            /**
             * This code is only for local run
             */
            builder.setRootUrl("http://10.0.3.2:8080/_ah/api/");
            builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                    request.setDisableGZipContent(true);
                }
            });
            //builder.setRootUrl("http://jokeapi-1228.appspot.com/_ah/api/");
            jokesAPI = builder.build();
        }
        try {
            responce = jokesAPI.getJoke().execute().getData();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            responce = "No Joke";
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (progressDialog != null) progressDialog.dismiss();
        if (result){
            if (listener != null) listener.OnSuccess(responce);
        }else {
            if (listener != null) listener.OnError(responce);
        }
    }

    public void setListener(OnJokeListener listener) {
        this.listener = listener;
    }
}
