package com.kelvinhado.stootie.stooties;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelvinhado.stootie.R;
import com.kelvinhado.stootie.data.model.Stootie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 09/10/2017.
 */

public class StootiesFragment extends Fragment implements StootiesContract.View,
        StootiesAdapter.ListItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = StootiesFragment.class.getSimpleName();

    /**
     * Mvp presenter
     */
    private StootiesContract.Presenter mPresenter;

    /**
     * List of stooties
     */
    private List<Stootie> mStootieList;

    @BindView(R.id.rv_stooties)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private StootiesAdapter mAdapter;

    public StootiesFragment() {
        // Requires empty public constructor
    }

    public static StootiesFragment newInstance() {
        return new StootiesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStootieList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_stooties, container, false);
        ButterKnife.bind(this, mRootView);

        mAdapter = new StootiesAdapter(getContext(), mStootieList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mPresenter.start();
        return mRootView;
    }

    @Override
    public void setPresenter(StootiesContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if(active && !mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(true);
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showStooties(List<Stootie> stooties) {
        mAdapter.swap(stooties);
        mStootieList = stooties;
    }

    @Override
    public void showLoadingStootiesFailed() {
        Log.d(TAG, "unable to load data..");
    }

    @Override
    public void onListItemClicked(int itemPosition) {

    }
    /**
     * Methods called when the user swipe to update the content.
     */
    @Override
    public void onRefresh() {
        mPresenter.loadStooties(true);
    }
}
