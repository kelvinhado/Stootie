package com.kelvinhado.stootie.stootie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kelvinhado.stootie.R;
import com.kelvinhado.stootie.data.model.Stootie;

import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 16/10/2017.
 */

public class StootieFragment extends Fragment implements StootieContract.View {

    private static final String TAG = StootieFragment.class.getSimpleName();

    /**
     * Mvp presenter
     */
    private StootieContract.Presenter mPresenter;


    public StootieFragment() {
        // Requires empty public constructor
    }

    public static StootieFragment newInstance() {
        return new StootieFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_stootie, container, false);
        ButterKnife.bind(this, mRootView);

        //init views
        mPresenter.start();
        return mRootView;
    }


    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showStootie(Stootie stootie) {
        Toast.makeText(getActivity(), stootie.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingStootieFailed() {
        Toast.makeText(getActivity(), "loading failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(StootieContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }
}
