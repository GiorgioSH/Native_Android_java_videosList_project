package com.ita.mybestyoutube;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class YoutubeDAO extends DAO{
    public YoutubeDAO(Context context) { super(new YoutubeVideoDBHelper(context));}

    public YoutubeVideo find (Long id){
        YoutubeVideo youtubeVideo = null;
        open();

        Cursor cursor =db.rawQuery("select * from " + YoutubeVideoDBHelper.YOUTUBEVIDEO_TABLE_NAME +
                        " where " + YoutubeVideoDBHelper.YOUTUBEVIDEO_KEY_COLUMN_INDEX + " =?",
                new String[]{ String.valueOf(id) });

        if (cursor != null && cursor.moveToFirst()) {
            youtubeVideo = new YoutubeVideo();
            youtubeVideo.setId(Integer.parseInt(cursor.getString(0)));
            youtubeVideo.setTitle(cursor.getString(1));
            youtubeVideo.setDescription(cursor.getString(2));
            youtubeVideo.setUrl(cursor.getString(3));
            youtubeVideo.setCategory(cursor.getString(4));

            cursor.close();
        }
        close();
        return youtubeVideo;
    }
    public List<YoutubeVideo> list(){
        open();

        List<YoutubeVideo> youtubeVideos = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " +
                YoutubeVideoDBHelper.YOUTUBEVIDEO_TABLE_NAME, null);

        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                YoutubeVideo youtubevideo = new YoutubeVideo();
                youtubevideo.setId(cursor.getInt(YoutubeVideoDBHelper.YOUTUBEVIDEO_KEY_COLUMN_INDEX));
                youtubevideo.setTitle(cursor.getString(YoutubeVideoDBHelper.YOUTUBEVIDEO_TITLE_COLUMN_INDEX));
                youtubevideo.setDescription(cursor.getString(YoutubeVideoDBHelper.YOUTUBEVIDEO_DESCRIPTION_COLUMN_INDEX));
                youtubevideo.setUrl(cursor.getString(YoutubeVideoDBHelper.YOUTUBEVIDEO_URL_COLUMN_INDEX));
                youtubevideo.setCategory(cursor.getString(YoutubeVideoDBHelper.YOUTUBEVIDEO_CATEGORY_COLUMN_INDEX));

                youtubeVideos.add(youtubevideo);

                cursor.moveToNext();
            }
        }
        cursor.close();
        return youtubeVideos;
    }

    public void add(YoutubeVideo youtubeVideo){
        open();

        ContentValues value = new ContentValues();

        value.put(YoutubeVideoDBHelper.YOUTUBEVIDEO_TITLE, youtubeVideo.getTitle());
        value.put(YoutubeVideoDBHelper.YOUTUBEVIDEO_DESCRIPTION, youtubeVideo.getDescription());
        value.put(YoutubeVideoDBHelper.YOUTUBEVIDEO_URL, youtubeVideo.getUrl());
        value.put(YoutubeVideoDBHelper.YOUTUBEVIDEO_CATEGORY, youtubeVideo.getCategory());

        Long id = db.insert(YoutubeVideoDBHelper.YOUTUBEVIDEO_TABLE_NAME, null, value);
        youtubeVideo.setId(id);

        close();
    }
}
