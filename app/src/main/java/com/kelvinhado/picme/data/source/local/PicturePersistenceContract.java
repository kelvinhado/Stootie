package com.kelvinhado.picme.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by kelvin on 10/10/2017.
 */

public final class PicturePersistenceContract {

    //private to prevent accidentally instantiating the contract class
    private PicturePersistenceContract() {}

    /**
     * Inner class that defines the table contents
     * */
    public static final class PictureEntry implements BaseColumns {
        public static final String TABLE_NAME = "pictures";
        public static final String COLUMN_NAME_ENTRY_ID = "entryId";
        public static final String COLUMN_NAME_ID = "pictureId";
        public static final String COLUMN_NAME_ALBUM_ID = "albumId";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PICTURE_URL = "url";
        public static final String COLUMN_NAME_THUMBNAIL_URL = "thumbnailUrl";
    }
}
