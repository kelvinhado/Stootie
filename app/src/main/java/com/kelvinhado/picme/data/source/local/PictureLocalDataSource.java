package com.kelvinhado.picme.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.kelvinhado.picme.data.source.Picture;
import com.kelvinhado.picme.data.source.PictureDataSource;
import com.kelvinhado.picme.data.source.local.PicturePersistenceContract.PictureEntry;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 10/10/2017.
 */

public class PictureLocalDataSource implements PictureDataSource {

    private final String TAG = PictureLocalDataSource.class.getSimpleName();
    /**
     * Single instance
     */
    private static PictureLocalDataSource sInstance;

    /**
     * Sqlite databse helper
     */
    private final PicturesDbHelper mDbHelper;

    //prevent direct instantiation
    private PictureLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        mDbHelper = new PicturesDbHelper(context);
    }

    public static PictureLocalDataSource getInstance(@NonNull Context context) {
        if (sInstance == null) {
            sInstance = new PictureLocalDataSource(context);
        }
        return sInstance;
    }

    /**
     * Gets the stored pictures from the local sqlite database
     *
     * @param callback results
     */
    @Override
    public void getPictures(@NonNull final LoadPicturesCallback callback) {
        callback.onDataNotAvailable();
        new AsyncTask<Void, Void, List<Picture>>() {

            @Override
            protected List<Picture> doInBackground(Void... params) {
                List<Picture> pictures = new ArrayList<>();
                SQLiteDatabase db = mDbHelper.getReadableDatabase();

                String[] projection = {
                        PictureEntry.COLUMN_NAME_ID,
                        PictureEntry.COLUMN_NAME_ALBUM_ID,
                        PictureEntry.COLUMN_NAME_TITLE,
                        PictureEntry.COLUMN_NAME_PICTURE_URL,
                        PictureEntry.COLUMN_NAME_THUMBNAIL_URL
                };

                Cursor c = db.query(
                        PictureEntry.TABLE_NAME, projection, null, null, null, null, null);

                // if results from db
                if (c != null && c.getCount() > 0) {
                    while (c.moveToNext()) {
                        Picture picture = new Picture();
                        try {
                            picture.setId(c.getInt(c.getColumnIndexOrThrow(PictureEntry.COLUMN_NAME_ID)));
                            picture.setAlbumId(c.getInt(c.getColumnIndexOrThrow(PictureEntry.COLUMN_NAME_ALBUM_ID)));
                            picture.setTitle(c.getString(c.getColumnIndexOrThrow(PictureEntry.COLUMN_NAME_TITLE)));
                            picture.setUrl(c.getString(c.getColumnIndexOrThrow(PictureEntry.COLUMN_NAME_PICTURE_URL)));
                            picture.setThumbnailUrl(c.getString(c.getColumnIndexOrThrow(PictureEntry.COLUMN_NAME_THUMBNAIL_URL)));
                        } catch (Exception e) {
                            Log.e(TAG, "local db populating failed");
                        }
                        pictures.add(picture);
                    }
                }
                if (c != null) {
                    c.close();
                }
                return pictures;
            }

            @Override
            protected void onPostExecute(List<Picture> pictures) {
                super.onPostExecute(pictures);
                if (pictures.isEmpty()) {
                    // This will be called if the table is new or just empty.
                    Log.d(TAG, "no data found");
                    callback.onDataNotAvailable();
                } else {
                    Log.d(TAG, "data found");
                    callback.onPicturesLoaded(pictures);
                }
            }
        }.execute();

    }


    @Override
    public void deleteAllPictures() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                db.delete(PictureEntry.TABLE_NAME, null, null);
                db.close();
                return null;
            }
        }.execute();
    }

    @Override
    public void savePicture(@NonNull final Picture picture) {
        checkNotNull(picture);
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(PictureEntry.COLUMN_NAME_ID, picture.getId());
                values.put(PictureEntry.COLUMN_NAME_ALBUM_ID, picture.getAlbumId());
                values.put(PictureEntry.COLUMN_NAME_TITLE, picture.getTitle());
                values.put(PictureEntry.COLUMN_NAME_PICTURE_URL, picture.getUrl());
                values.put(PictureEntry.COLUMN_NAME_THUMBNAIL_URL, picture.getThumbnailUrl());
                db.insert(PictureEntry.TABLE_NAME, null, values);
                db.close();
                return null;
            }
        }.execute();

    }
}
