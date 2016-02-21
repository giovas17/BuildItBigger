package com.udacity.gradle.builditbigger.paid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.giovas.JokesProvider;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private TextView jokeText;
    private Button tellJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        jokeText = (TextView) root.findViewById(R.id.textViewJoke);
        tellJoke = (Button) root.findViewById(R.id.button);
        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jokeText.setText("Joke:\n\n" + JokesProvider.getJokes());
            }
        });
        return root;
    }
}
