package com.ita.mybestyoutube;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddYoutubeVideo extends AppCompatActivity {

    private EditText tvTitle;
    private EditText tvDescription;
    private EditText tvUrl;
    private Spinner spCategory;
    private Button btnAdd;
    private Button btnCancel;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_youtube_video);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        context = getApplicationContext();
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvUrl = findViewById(R.id.tvUrl);
        spCategory = findViewById(R.id.spCategory);

        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

        String[] cat = new String[]{
                "Sport",
                "Music",
                "Comedy",
                "Cuisine"
        };

        final List<String> catlist = new ArrayList<>(Arrays.asList(cat));

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                context, R.layout.spinner_item,catlist);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spCategory.setAdapter(spinnerArrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = tvTitle.getText().toString();
                String description = tvDescription.getText().toString();
                String url = tvUrl.getText().toString();

                String category = spCategory.getSelectedItem().toString();

                if(title.isEmpty() || description.isEmpty() || url.isEmpty()){
                    int duration = Toast.LENGTH_SHORT;
                    CharSequence text = "Veuillez remplir tout les champs!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    YoutubeVideo youtubeVideo = new YoutubeVideo(title, description, url, category);

                    YoutubeDAO youtubeDAO = new YoutubeDAO(getApplicationContext());
                    youtubeDAO.add(youtubeVideo);

                    finish();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}