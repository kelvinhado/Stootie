package com.kelvinhado.stootie.stooties;

import android.support.annotation.NonNull;

import com.kelvinhado.stootie.BasePresenter;
import com.kelvinhado.stootie.data.model.Picture;
import com.kelvinhado.stootie.data.source.StootieDataSource;
import com.kelvinhado.stootie.data.source.StootieRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 09/10/2017.
 */

public class StootiesPresenter implements BasePresenter, StootiesContract.Presenter {

    private final StootiesContract.View mPicturesView;

    private final StootieRepository mRepository;

    public StootiesPresenter(@NonNull StootieRepository repository,
                             @NonNull StootiesContract.View picturesView) {
        mPicturesView = checkNotNull(picturesView, "PicturesView cannot be null");
        mPicturesView.setPresenter(this);
        mRepository = repository;
    }

    /**
     * Method called when the view is initialized
     */
    @Override
    public void start() {
        loadPictures(false);
    }

    /**
     * Loads pictures from data source.
     *
     * @param forceUpdate true to clear cache
     */
    @Override
    public void loadPictures(boolean forceUpdate) {
        mPicturesView.setLoadingIndicator(true);
        // if a data update is required.
        if (forceUpdate) {
            mRepository.refreshData();
        }
        // get pictures from the data source.
        mRepository.getStooties(new StootieDataSource.LoadStootiesCallback() {
            @Override
            public void onPicturesLoaded(@NonNull List<Picture> pictures) {
                mPicturesView.showPictures(pictures);
                mPicturesView.setLoadingIndicator(false);
            }

            @Override
            public void onDataNotAvailable() {
                mPicturesView.showLoadingPicturesFailed();
                mPicturesView.setLoadingIndicator(false);
            }
        });
    }
}
