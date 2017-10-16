package com.kelvinhado.stootie.stooties;

import com.kelvinhado.stootie.BasePresenter;
import com.kelvinhado.stootie.BaseView;
import com.kelvinhado.stootie.data.model.Stootie;

import java.util.List;

/**
 * Created by kelvin on 01/10/2017.
 */

public interface StootiesContract {

    interface View extends BaseView<Presenter> {

        /**
         * Manage the loader
         * @param active true to show the loader
         */
        void setLoadingIndicator(boolean active);

        /**
         * Shows loaded stooties
         * @param stooties stooties
         */
        void showStooties(List<Stootie> stooties);

        /**
         * Shows alert in case no stooties are found
         */
        void showLoadingStootiesFailed();

    }

    interface Presenter extends BasePresenter {

        /**
         * request to load stooties
         * @param forceUpdate true to clear cache
         */
        void loadStooties(boolean forceUpdate);

    }
}
