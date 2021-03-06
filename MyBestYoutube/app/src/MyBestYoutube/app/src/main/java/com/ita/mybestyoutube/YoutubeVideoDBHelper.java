package com.ita.mybestyoutube;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class YoutubeVideoDBHelper extends SQLiteOpenHelper{
    private static final int VERSION = 3;
    private static final String DATABASE_NAME = "youtubevideo.db";

    public static final String YOUTUBEVIDEO_KEY = "id";
    public static final String YOUTUBEVIDEO_TITLE = "title";
    public static final String YOUTUBEVIDEO_DESCRIPTION = "description";
    public static final String YOUTUBEVIDEO_URL = "url";
    public static final String YOUTUBEVIDEO_CATEGORY = "category";

    public static final String YOUTUBEVIDEO_TABLE_NAME = "Youtubevideo";

    public static final int YOUTUBEVIDEO_KEY_COLUMN_INDEX = 0;
    public static final int YOUTUBEVIDEO_TITLE_COLUMN_INDEX = 1;
    public static final int YOUTUBEVIDEO_DESCRIPTION_COLUMN_INDEX = 2;
    public static final int YOUTUBEVIDEO_URL_COLUMN_INDEX = 3;
    public static final int YOUTUBEVIDEO_CATEGORY_COLUMN_INDEX = 4;

    public YoutubeVideoDBHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    private static  final String YOUTUBEVIDEO_TABLE_CREATE =
            "CREATE TABLE " + YOUTUBEVIDEO_TABLE_NAME + " (" +
                    YOUTUBEVIDEO_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    YOUTUBEVIDEO_TITLE + " TEXT, " +
                    YOUTUBEVIDEO_DESCRIPTION + " TEXT, " +
                    YOUTUBEVIDEO_URL + " TEXT, " +
                    YOUTUBEVIDEO_CATEGORY + " TEXT);";

    private static final String YOUTUBEVIDEO_TABLE_DROP = "DROP TABLE IF EXISTS " + YOUTUBEVIDEO_TABLE_NAME + ";";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(YOUTUBEVIDEO_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(YOUTUBEVIDEO_TABLE_DROP);
        onCreate(db);
    }
}
