package com.kelvinhado.stootie.data.source;

import android.support.annotation.NonNull;

import com.kelvinhado.stootie.data.model.Stootie;

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
public class StootieRepository implements StootieDataSource {

    /**
     * Single instance
     */
    private static StootieRepository sInstance = null;

    /**
     * remote data source
     */
    private final StootieDataSource mRemoteDataSource;


    /**
     * cache data
     */
    private Map<Integer, Stootie> mCache;

    /**
     * whether the cache need to be reloaded or not
     */
    private boolean mCacheIsDirty = false;


    // prevent direct instantiation
    private StootieRepository(@NonNull StootieDataSource remoteDataSource) {
        mRemoteDataSource = checkNotNull(remoteDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param remoteDataSource the remote backend data source
     * @return the {@link StootieRepository} instance
     */
    public static StootieRepository getInstance(StootieDataSource remoteDataSource) {
        if (sInstance == null) {
            sInstance = new StootieRepository(remoteDataSource);
        }
        return sInstance;
    }

    /**
     * Gets stooties from local data source or remote data source, whichever is available first.
     * <p>
     * Note: {@link LoadStootiesCallback#onDataNotAvailable()} is fired if all data sources fail to
     * get the data.
     */
    @Override
    public void getStooties(@NonNull final LoadStootiesCallback callback) {
        // Respond immediately with cache if available and not dirty
        if (mCache != null && !mCacheIsDirty) {
            callback.onStootiesLoaded(getCachedStooties());
            return;
        } else {
            getStootiesFromRemoteDataSource(callback);
        }
    }

    @Override
    public void getStootie(@NonNull final LoadStootieCallback callback) {
        mRemoteDataSource.getStootie(new LoadStootieCallback() {
            @Override
            public void onStootieLoaded(@NonNull Stootie stootie) {
                callback.onStootieLoaded(stootie);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    /**
     * Fetch stooties from the remote server
     *
     * @param callback data fetched
     */
    private void getStootiesFromRemoteDataSource(@NonNull final LoadStootiesCallback callback) {
        mRemoteDataSource.getStooties(new LoadStootiesCallback() {
            @Override
            public void onStootiesLoaded(@NonNull List<Stootie> stooties) {
                mCacheIsDirty = false;
                refreshCache(stooties);
                callback.onStootiesLoaded(getCachedStooties());
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    /**
     * Refresh the memory cache
     * @param stooties list of stooties that need to be cached
     */
    private void refreshCache(List<Stootie> stooties) {
        if (mCache == null) {
            mCache = new LinkedHashMap<>();
        }
        mCache.clear();
        for (Stootie stootie : stooties) {
            mCache.put(stootie.getId(), stootie);
        }
        mCacheIsDirty = false;
    }

    /**
     * Gets cached value
     * @return list of cached stooties
     */
    private List<Stootie> getCachedStooties() {
        return new ArrayList<>(mCache.values());
    }

    @Override
    public void refreshData() {
        mCacheIsDirty = true;
    }
}
