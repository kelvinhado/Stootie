package com.kelvinhado.picme.pictures;

import android.support.annotation.NonNull;

import com.kelvinhado.picme.BasePresenter;
import com.kelvinhado.picme.data.source.Picture;

import java.util.ArrayList;

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

    }

    @Override
    public void loadPictures(boolean forceUpdate) {
        Picture pic = new Picture();
        pic.setTitle("uno");
        pic.setThumbnailUrl("http://placehold.it/150/92c952");
        Picture pic2 = new Picture();
        pic2.setTitle("dos");
        pic2.setThumbnailUrl("http://placehold.it/150/d32776");
        Picture pic3 = new Picture();
        pic3.setTitle("tres");
        pic3.setThumbnailUrl("http://placehold.it/150/56a8c2");
        Picture pic4 = new Picture();
        pic4.setTitle("cuatro");
        pic4.setThumbnailUrl("http://placehold.it/150/5e3a73");
        ArrayList<Picture> pics = new ArrayList<Picture>();
        pics.add(pic);
        pics.add(pic2);
        pics.add(pic3);
        pics.add(pic4);
        mPicturesView.showPictures(pics);
    }
}
