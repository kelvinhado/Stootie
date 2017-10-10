package com.kelvinhado.picme.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kelvin on 10/10/2017.
 */

public class PicturesDbHelper extends SQLiteOpenHelper {
    
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Pictures.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String REAL_TYPE = " REAL";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PicturePersistenceContract.PictureEntry.TABLE_NAME + " (" +
                    PicturePersistenceContract.PictureEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + " PRIMARY KEY," +
                    PicturePersistenceContract.PictureEntry.COLUMN_NAME_ID + REAL_TYPE + COMMA_SEP +
                    PicturePersistenceContract.PictureEntry.COLUMN_NAME_ALBUM_ID + REAL_TYPE + COMMA_SEP +
                    PicturePersistenceContract.PictureEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    PicturePersistenceContract.PictureEntry.COLUMN_NAME_PICTURE_URL + TEXT_TYPE + COMMA_SEP +
                    PicturePersistenceContract.PictureEntry.COLUMN_NAME_THUMBNAIL_URL + TEXT_TYPE +
                    " )";

    public PicturesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // To simplify we'll just drop the table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + PicturePersistenceContract.PictureEntry.TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }
}
