package com.vogella.android.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_now_playing is used as a template to display view created in this class.
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();
        TextView NowPlaying = findViewById(R.id.NowPlaying);
        NowPlaying.setText(intent.getStringExtra("title") + " by " + intent.getStringExtra("song"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}