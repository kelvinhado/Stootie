package com.kelvinhado.stootie.data.source;

import android.support.annotation.NonNull;

import com.kelvinhado.stootie.data.model.Stootie;

import java.util.List;

/**
 * Created by kelvin on 10/10/2017.
 */

public interface StootieDataSource {

    /**
     * Gets the stooties from the data source
     * @param callback callback
     */
    void getStooties(@NonNull LoadStootiesCallback callback);

    /**
     * Gets the stooties from the data source
     * @param callback callback
     */
    void getStootie(@NonNull LoadStootieCallback callback);

    /**
     * Methods called to indicate that data should be updated
     */
    void refreshData();

    interface LoadStootiesCallback {

        void onStootiesLoaded(@NonNull List<Stootie> pictures);

        void onDataNotAvailable();
    }

    interface LoadStootieCallback {

        void onStootieLoaded(@NonNull Stootie stootie);

        void onDataNotAvailable();
    }
}
