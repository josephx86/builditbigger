package com.udacity.gradle.builditbigger.jokeuilibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeActivity extends AppCompatActivity {
    @BindView(R2.id.joke_tv)
    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        ButterKnife.bind(this);

        // Get the joke? (no pun intended XD)
        String joke = getString(R.string.lame_joke);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String key = getString(R.string.joke_key);
            if (extras.containsKey(key)) {
                joke = extras.getString(key);
            }
        }

        jokeTextView.setText(joke);
    }
}
