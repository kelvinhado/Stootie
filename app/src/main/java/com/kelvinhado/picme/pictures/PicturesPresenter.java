package com.kelvinhado.picme.pictures;

import android.support.annotation.NonNull;

import com.kelvinhado.picme.BasePresenter;
import com.kelvinhado.picme.data.source.Picture;
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

    public PicturesPresenter(@NonNull PictureRepository repository, @NonNull PicturesContract.View picturesView) {
        mPicturesView = checkNotNull(picturesView, "PicturesView cannot be null");
        mPicturesView.setPresenter(this);
        mRepository = repository;
    }

    @Override
    public void start() {

    }

    @Override
    public void loadPictures(boolean forceUpdate) {
        mRepository.getPictures(new PictureDataSource.LoadPicturesCallback() {
            @Override
            public void onPicturesLoaded(@NonNull List<Picture> pictures) {
                mPicturesView.showPictures(pictures);
            }

            @Override
            public void onDataNotAvailable() {
                mPicturesView.showNoPicture();
            }
        });
    }
}
