package com.kelvinhado.picme.pictures;

import com.kelvinhado.picme.BasePresenter;
import com.kelvinhado.picme.BaseView;
import com.kelvinhado.picme.data.source.Picture;

import java.util.List;

/**
 * Created by kelvin on 01/10/2017.
 */

public interface PicturesContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showPictures(List<Picture> pictures);

        void showNoPicture();

        void showLoadingPictureError();
    }

    interface Presenter extends BasePresenter {

        void loadPictures(boolean forceUpdate);

    }
}
