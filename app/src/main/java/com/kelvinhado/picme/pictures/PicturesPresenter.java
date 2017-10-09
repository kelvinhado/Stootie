package com.kelvinhado.picme.pictures;

import com.kelvinhado.picme.BasePresenter;

/**
 * Created by kelvin on 09/10/2017.
 */

public class PicturesPresenter implements BasePresenter, PicturesContract.Presenter {

    public PicturesPresenter() {
    }

    @Override
    public void start() {
        loadPictures(false);
    }

    @Override
    public void loadPictures(boolean forceUpdate) {

    }
}
