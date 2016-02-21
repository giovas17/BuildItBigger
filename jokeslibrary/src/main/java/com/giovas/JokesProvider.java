package com.giovas;

import java.util.Random;

public class JokesProvider {

    private static final String[] JOKES = {"Joke 1", "Joke 2", "Joke 3", "Joke 4", "Joke 5"};

    public static String getJokes() {
        Random rand = new Random();
        return JOKES[rand.nextInt(JOKES.length)];
    }
}
