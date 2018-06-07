package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.JokeAsyncTask;

public class NotEmptyJokeTest extends AndroidTestCase {

    public void testAsynTaskReturnsNotEmptyJoke() {

        String result = null;
        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(getContext());

        try {
            jokeAsyncTask.execute();
            result = jokeAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(result);
    }
}
