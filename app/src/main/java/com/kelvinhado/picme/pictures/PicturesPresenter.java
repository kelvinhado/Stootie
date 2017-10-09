package com.kelvinhado.picme.pictures;

import android.support.annotation.NonNull;

import com.kelvinhado.picme.BasePresenter;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 09/10/2017.
 */

public class PicturesPresenter implements BasePresenter, PicturesContract.Presenter {

    private final PicturesContract.View mPicturesView;

    public PicturesPresenter(@NonNull PicturesContract.View picturesView) {
        mPicturesView = checkNotNull(picturesView, "PicturesView cannot be null");
        mPicturesView.setPresenter(this);
    }

    @Override
    public void start() {
        loadPictures(false);
    }

    @Override
    public void loadPictures(boolean forceUpdate) {

    }
}
