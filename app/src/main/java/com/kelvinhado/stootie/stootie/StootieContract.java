package com.kelvinhado.stootie.stootie;

import com.kelvinhado.stootie.BasePresenter;
import com.kelvinhado.stootie.BaseView;
import com.kelvinhado.stootie.data.model.Stootie;

/**
 * Created by kelvin on 16/10/2017.
 */

public interface StootieContract {

    interface View extends BaseView<Presenter> {

        /**
         * Manage the loader
         * @param active true to show the loader
         */
        void setLoadingIndicator(boolean active);

        /**
         * Shows loaded stootie
         * @param stootie stootie
         */
        void showStootie(Stootie stootie);

        /**
         * Shows alert in case the data is not found
         */
        void showLoadingStootieFailed();

    }

    interface Presenter extends BasePresenter {

        /**
         * load stootie from the remote datasource
         * @param forceUpdate whether the data needs to be reloaded
         */
        void requestLoadStootie(boolean forceUpdate);

    }
}
