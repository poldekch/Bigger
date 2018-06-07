package com.example.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        String joke = getIntent().getStringExtra("JOKE");

        TextView tvJoke = findViewById(R.id.tv_joke);
        tvJoke.setText(joke);
    }
}
