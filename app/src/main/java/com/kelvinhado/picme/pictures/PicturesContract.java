package com.kelvinhado.picme.pictures;

import com.kelvinhado.picme.BasePresenter;
import com.kelvinhado.picme.BaseView;
import com.kelvinhado.picme.data.model.Picture;

import java.util.List;

/**
 * Created by kelvin on 01/10/2017.
 */

public interface PicturesContract {

    interface View extends BaseView<Presenter> {

        /**
         * Manage the loader
         * @param active true to show the loader
         */
        void setLoadingIndicator(boolean active);

        /**
         * Shows loaded pictures
         * @param pictures pictures
         */
        void showPictures(List<Picture> pictures);

        /**
         * Shows alert in case no pictures are found
         */
        void showLoadingPicturesFailed();

    }

    interface Presenter extends BasePresenter {

        /**
         * request to load pictures
         * @param forceUpdate true to clear cache
         */
        void loadPictures(boolean forceUpdate);

    }
}
