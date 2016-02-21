package com.darkgeat.jokesandroidlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DarkGeat on 2/16/2016.
 */
public class JokeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke,container,false);

        TextView textJoke = (TextView)v.findViewById(R.id.textViewJoke);
        String joke = getActivity().getIntent().getStringExtra("joke");
        Log.d(JokeFragment.class.getSimpleName(),joke);
        textJoke.setText("Joke: " + joke);

        return v;
    }
}
