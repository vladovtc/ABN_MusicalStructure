package com.gmail.vtc.vlado.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        /**
         * Initialize Toolbar and set properties
         */

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /**
         * Initialize Views
         */

        textView = findViewById(R.id.tv_artist_and_song);
        imageView = findViewById(R.id.image_view);

        /**
         * Get data from Intent and set it to text and image view
         */

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();

        final int imageId = extras.getInt("artist_image");
        final String music = intent.getStringExtra("artist_name");

        textView.setText(music);
        imageView.setImageResource(imageId);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
