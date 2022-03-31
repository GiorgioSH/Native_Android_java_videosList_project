package com.ita.mybestyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetail;
    private Button btnWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        tvDetail = findViewById(R.id.tvDetail);
        btnWatch = findViewById(R.id.btnWatch);

        Intent intent = getIntent();
        YoutubeVideo youtubeVideo = (YoutubeVideo)intent.getSerializableExtra("youtubevideo");

        tvDetail.setText(String.format("%s\n %s\n %s\n %s\n",
                youtubeVideo.getTitle(), youtubeVideo.getDescription(), youtubeVideo.getUrl(), youtubeVideo.getCategory()));

        btnWatch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(youtubeVideo.getUrl()));
                try {
                    DetailActivity.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            };
        });
    }
}