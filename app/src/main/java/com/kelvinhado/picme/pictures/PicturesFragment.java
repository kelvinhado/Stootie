package com.kelvinhado.picme.pictures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelvinhado.picme.R;
import com.kelvinhado.picme.data.source.Picture;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 09/10/2017.
 */

public class PicturesFragment extends Fragment implements PicturesContract.View {

    /**
     * Mvp presenter
     */
    private PicturesContract.Presenter mPresenter;

    /**
     * List of pictures
     */
    private List<Picture> mPictureList;

    @BindView(R.id.rv_pictures)
    RecyclerView mRecyclerView;

    private PicturesAdapter mAdapter;

    public PicturesFragment() {
        // Requires empty public constructor
    }

    public static PicturesFragment newInstance() {
        return new PicturesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPictureList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_pictures, container, false);
        ButterKnife.bind(this, mRootView);

        mAdapter = new PicturesAdapter(mPictureList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.loadPictures(false);
        return mRootView;
    }

    @Override
    public void setPresenter(PicturesContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showPictures(List<Picture> pictures) {

    }

    @Override
    public void showNoPicture() {

    }

    @Override
    public void showLoadingPictureError() {

    }
}
