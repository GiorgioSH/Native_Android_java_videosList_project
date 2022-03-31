package com.ita.mybestyoutube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_YOUTUBEVIDEO = "youtubevideo";
    private Context context;
    private RecyclerView rvYoutubevideos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setContentView(R.layout.recyclerview_main);


        rvYoutubevideos = findViewById(R.id.rvYoutubevideo);
        context = getApplicationContext();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvYoutubevideos.setHasFixedSize(true);

        rvYoutubevideos.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        YoutubeDAO youtubeDAO = new YoutubeDAO(context);
        List<YoutubeVideo> youtubeVideos = youtubeDAO.list();

        // créé l'adapteur et l'affecte au recyclerview
        YoutubeVideoAdapter youtubevideoAdapter = new YoutubeVideoAdapter(youtubeVideos, new YoutubeVideoAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(YoutubeVideo item) { // méthode qui va s"exécuter quand on click sur l'item
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("youtubevideo", item);

                startActivity(intent);
            }
        });
        rvYoutubevideos.setAdapter(youtubevideoAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.addYoutubevideo:

                Intent intent = new Intent(context, AddYoutubeVideo.class);

                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}