package com.kelvinhado.picme.pictures;

import android.support.annotation.NonNull;

import com.kelvinhado.picme.BasePresenter;
import com.kelvinhado.picme.data.model.Picture;
import com.kelvinhado.picme.data.source.PictureDataSource;
import com.kelvinhado.picme.data.source.PictureRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 09/10/2017.
 */

public class PicturesPresenter implements BasePresenter, PicturesContract.Presenter {

    private final PicturesContract.View mPicturesView;

    private final PictureRepository mRepository;

    public PicturesPresenter(@NonNull PictureRepository repository,
                             @NonNull PicturesContract.View picturesView) {
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
        mRepository.getPictures(new PictureDataSource.LoadPicturesCallback() {
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
