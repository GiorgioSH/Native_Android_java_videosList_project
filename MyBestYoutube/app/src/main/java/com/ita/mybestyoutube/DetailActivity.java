package com.ita.mybestyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        tvDetail = findViewById(R.id.tvDetail);
        Intent intent = getIntent();
        YoutubeVideo youtubeVideo = (YoutubeVideo)intent.getSerializableExtra("youtubevideo");

        tvDetail.setText(String.format("%s\n %s\n %s\n %s\n",
                youtubeVideo.getTitle(), youtubeVideo.getDescription(), youtubeVideo.getUrl(), youtubeVideo.getCategory()));
    }
}