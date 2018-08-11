package com.udacity.gradle.builditbigger.app;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.JokeAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class AsyncJokeTest {

    @Test
    public void getJoke() {
        try {
            final CountDownLatch latch = new CountDownLatch(1);

            // Only wait about 5 secs for this test
            latch.await(5, TimeUnit.SECONDS);

            JokeAsyncTask jokeAsyncTask = new JokeAsyncTask() {
                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);
                    assert(result != null && !result.isEmpty());
                    latch.countDown();
                }
            };

            // No need for a context during the test
            // because the task uses the context to start an activity (not required here)
            jokeAsyncTask.execute();
        } catch (InterruptedException e) {

        }
    }
}
