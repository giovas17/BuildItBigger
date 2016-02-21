package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Log;

import com.udacity.gradle.listeners.OnJokeListener;
import com.udacity.gradle.network.JokeTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created by DarkGeat on 2/21/2016.
 */
public class AsynctaskAndroidTest extends ApplicationTestCase<Application> {
    private static final String ASYNC_TEST_TAG = "ASYNC_TEST_TAG";
    private String mJokeString = null;
    private Exception mError = null;
    private CountDownLatch signal = null;

    public AsynctaskAndroidTest() {
        super(Application.class);
    }


    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }


    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testEndpointGetJoke() throws InterruptedException {
        JokeTask task = new JokeTask();

        //noinspection unchecked
        task.setListener(new OnJokeListener() {
            @Override
            public void OnSuccess(String response) {
                mJokeString = response;
                signal.countDown();
            }

            @Override
            public void OnError(String error) {
                mJokeString = error;
            }
        });
        task.execute();

        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(mJokeString));
        assertTrue(mJokeString != null && mJokeString.length() > 0);
        Log.i(ASYNC_TEST_TAG, "Returned joke: " + mJokeString);
    }
}
