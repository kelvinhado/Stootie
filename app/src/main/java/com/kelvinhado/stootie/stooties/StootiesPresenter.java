package com.kelvinhado.stootie.stooties;

import android.support.annotation.NonNull;

import com.kelvinhado.stootie.BasePresenter;
import com.kelvinhado.stootie.data.model.Stootie;
import com.kelvinhado.stootie.data.source.StootieDataSource;
import com.kelvinhado.stootie.data.source.StootieRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 09/10/2017.
 */

public class StootiesPresenter implements BasePresenter, StootiesContract.Presenter {

    private final StootiesContract.View mStootiesView;

    private final StootieRepository mRepository;

    public StootiesPresenter(@NonNull StootieRepository repository,
                             @NonNull StootiesContract.View picturesView) {
        mStootiesView = checkNotNull(picturesView, "PicturesView cannot be null");
        mStootiesView.setPresenter(this);
        mRepository = repository;
    }

    /**
     * Method called when the view is initialized
     */
    @Override
    public void start() {
        requestLoadStooties(false);
    }

    /**
     * Loads pictures from data source.
     *
     * @param forceUpdate true to clear cache
     */
    @Override
    public void requestLoadStooties(boolean forceUpdate) {
        mStootiesView.setLoadingIndicator(true);
        // if a data update is required.
        if (forceUpdate) {
            mRepository.refreshData();
        }
        // get pictures from the data source.
        mRepository.getStooties(new StootieDataSource.LoadStootiesCallback() {
            @Override
            public void onStootiesLoaded(@NonNull List<Stootie> stooties) {
                mStootiesView.showStooties(stooties);
                mStootiesView.setLoadingIndicator(false);
            }

            @Override
            public void onDataNotAvailable() {
                mStootiesView.showLoadingStootiesFailed();
                mStootiesView.setLoadingIndicator(false);
            }
        });
    }

    @Override
    public void requestLoadStootie(String stootieId) {
        mStootiesView.showStootie(stootieId);
    }
}
