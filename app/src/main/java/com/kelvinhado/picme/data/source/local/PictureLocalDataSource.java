package com.kelvinhado.picme.data.source.local;

import android.support.annotation.NonNull;

import com.kelvinhado.picme.data.source.Picture;
import com.kelvinhado.picme.data.source.PictureDataSource;

/**
 * Created by kelvin on 10/10/2017.
 */

public class PictureLocalDataSource implements PictureDataSource {

    /**
     * Single instance
     */
    private static PictureLocalDataSource sInstance;

    //prevent direct instantiation
    private PictureLocalDataSource() {}

    public static PictureLocalDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new PictureLocalDataSource();
        }
        return sInstance;
    }

    @Override
    public void getPictures(@NonNull LoadPicturesCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void deleteAllPictures() {

    }

    @Override
    public void savePicture(@NonNull Picture picture) {

    }
}
