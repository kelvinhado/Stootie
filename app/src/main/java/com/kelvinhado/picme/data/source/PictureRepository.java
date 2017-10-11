package com.kelvinhado.picme.data.source;

import android.support.annotation.NonNull;

import com.kelvinhado.picme.data.model.Picture;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 10/10/2017.
 */

/**
 * This repository if the entry point to get data from the app
 */
public class PictureRepository implements PictureDataSource {

    /**
     * Single instance
     */
    private static PictureRepository sInstance = null;

    /**
     * remote data source
     */
    private final PictureDataSource mRemoteDataSource;

    /**
     * local data source
     */
    private final PictureDataSource mLocalDataSource;

    /**
     * cache data
     */
    private Map<Integer, Picture> mCache;

    /**
     * whether the cache need to be reloaded or not
     */
    private boolean mCacheIsDirty = false;


    // prevent direct instantiation
    private PictureRepository(@NonNull PictureDataSource remoteDataSource,
                              @NonNull PictureDataSource localDataSource) {
        mRemoteDataSource = checkNotNull(remoteDataSource);
        mLocalDataSource = checkNotNull(localDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param remoteDataSource the remote backend data source
     * @param localDataSource  the device storage data source
     * @return the {@link PictureRepository} instance
     */
    public static PictureRepository getInstance(PictureDataSource remoteDataSource,
                                         PictureDataSource localDataSource) {
        if (sInstance == null) {
            sInstance = new PictureRepository(remoteDataSource, localDataSource);
        }
        return sInstance;
    }

    /**
     * Gets pictures from local data source or remote data source, whichever is available first.
     * <p>
     * Note: {@link LoadPicturesCallback#onDataNotAvailable()} is fired if all data sources fail to
     * get the data.
     */
    @Override
    public void getPictures(@NonNull final LoadPicturesCallback callback) {
        // Respond immediately with cache if available and not dirty
        if (mCache != null && !mCacheIsDirty) {
            callback.onPicturesLoaded(getCachedPictures());
            return;
        }

        if (mCacheIsDirty) {
            // If the cache is dirty we need to fetch new data from the network.
            getPicturesFromRemoteDataSource(callback);
        } else {
            // Query the local storage if available. If not, query the network.
            mLocalDataSource.getPictures(new LoadPicturesCallback() {
                @Override
                public void onPicturesLoaded(@NonNull List<Picture> pictures) {
                    refreshCache(pictures);
                    callback.onPicturesLoaded(getCachedPictures());
                }

                @Override
                public void onDataNotAvailable() {
                    getPicturesFromRemoteDataSource(callback);
                }
            });
        }
    }

    /**
     * Fetch pictures from the remote server
     *
     * @param callback data fetched
     */
    private void getPicturesFromRemoteDataSource(@NonNull final LoadPicturesCallback callback) {
        mRemoteDataSource.getPictures(new LoadPicturesCallback() {
            @Override
            public void onPicturesLoaded(@NonNull List<Picture> pictures) {
                mCacheIsDirty = false;
                refreshCache(pictures);
                callback.onPicturesLoaded(getCachedPictures());
                refreshLocalStorage(pictures);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    /**
     * Refresh the memory cache
     * @param pictures list of pictures that need to be cached
     */
    private void refreshCache(List<Picture> pictures) {
        if (mCache == null) {
            mCache = new LinkedHashMap<>();
        }
        mCache.clear();
        for (Picture picture : pictures) {
            mCache.put(picture.getId(), picture);
        }
        mCacheIsDirty = false;
    }

    /**
     * Refresh the local storage
     * @param pictures list of pictures that needs to be saved in local storage
     */
    private void refreshLocalStorage(List<Picture> pictures) {
        mLocalDataSource.deleteAllPictures();
        for(Picture picture : pictures) {
            mLocalDataSource.savePicture(picture);
        }
    }

    /**
     * Gets cached value
     * @return list of cached pictures
     */
    private List<Picture> getCachedPictures() {
        return new ArrayList<>(mCache.values());
    }

    /**
     * Deletes remote and local pictures
     */
    @Override
    public void deleteAllPictures() {
        mRemoteDataSource.deleteAllPictures();
        mLocalDataSource.deleteAllPictures();
    }

    /**
     * Save the corresponding picture to both remote and local data source
     *
     * @param picture the picture thats need to be saved
     */
    @Override
    public void savePicture(@NonNull Picture picture) {
        mRemoteDataSource.savePicture(picture);
        mLocalDataSource.savePicture(picture);
    }

    @Override
    public void refreshData() {
        mCacheIsDirty = true;

    }
}
