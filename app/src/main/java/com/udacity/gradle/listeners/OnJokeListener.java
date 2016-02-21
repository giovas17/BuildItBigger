package com.udacity.gradle.listeners;

/**
 * Created by DarkGeat on 2/21/2016.
 */
public interface OnJokeListener {
    void OnSuccess(String response);
    void OnError(String error);
}
