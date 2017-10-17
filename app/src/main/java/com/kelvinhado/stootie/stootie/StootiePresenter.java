package com.kelvinhado.stootie.stootie;

import android.support.annotation.NonNull;

import com.kelvinhado.stootie.BasePresenter;
import com.kelvinhado.stootie.data.model.Stootie;
import com.kelvinhado.stootie.data.source.StootieDataSource;
import com.kelvinhado.stootie.data.source.StootieRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 16/10/2017.
 */

public class StootiePresenter implements BasePresenter, StootieContract.Presenter {

    private final StootieContract.View mStootieView;

    private final StootieRepository mRepository;

    public StootiePresenter(@NonNull StootieRepository repository,
                             @NonNull StootieContract.View stootieView) {
        mStootieView = checkNotNull(stootieView, "StootieView cannot be null");
        mStootieView.setPresenter(this);
        mRepository = repository;
    }
    
    @Override
    public void start() {

    }

    @Override
    public void requestLoadStootie(String stootieId, boolean forceUpdate) {
        mStootieView.setLoadingIndicator(true);
        // if a data update is required.
        if (forceUpdate) {
            mRepository.refreshData();
        }
        // get pictures from the data source.
        mRepository.getStootie(, new StootieDataSource.LoadStootieCallback() {
            @Override
            public void onStootieLoaded(@NonNull Stootie stootie) {
                mStootieView.setLoadingIndicator(false);
                mStootieView.showStootie(stootie);
            }

            @Override
            public void onDataNotAvailable() {
                mStootieView.showLoadingStootieFailed();
                mStootieView.setLoadingIndicator(false);
            }
        }, );
    }
}
