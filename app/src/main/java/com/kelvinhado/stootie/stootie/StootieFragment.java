package com.kelvinhado.stootie.stootie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kelvinhado.stootie.R;
import com.kelvinhado.stootie.data.model.Stootie;
import com.kelvinhado.stootie.utils.StringFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 16/10/2017.
 */

public class StootieFragment extends Fragment implements StootieContract.View, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = StootieFragment.class.getSimpleName();

    /**
     * Mvp presenter
     */
    private StootieContract.Presenter mPresenter;

    @BindView(R.id.tv_item_title)
    TextView title;
    @BindView(R.id.tv_item_user_firstname)
    TextView firstname;
    @BindView(R.id.tv_item_user_lastname)
    TextView lastname;
    @BindView(R.id.tv_item_price)
    TextView price;
    @BindView(R.id.tv_item_address)
    TextView address;
    @BindView(R.id.tv_item_date)
    TextView date;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

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
        mSwipeRefreshLayout.setOnRefreshListener(this);
        return mRootView;
    }


    @Override
    public void setLoadingIndicator(boolean active) {
        mSwipeRefreshLayout.setRefreshing(active);
    }

    @Override
    public void showStootie(Stootie stootie) {
        title.setText(stootie.getTitle());
        firstname.setText(stootie.getUserFirstName());
        lastname.setText(StringFormatter.formatLastName(stootie.getUserLastName()));
        price.setText(StringFormatter.formatPrice(getContext(), stootie.getPrice()));
        address.setText(stootie.getAddress());
        date.setText(StringFormatter.formatDate(stootie.getCreationDate()));
    }

    @Override
    public void showLoadingStootieFailed() {
        Toast.makeText(getActivity(), "loading failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(StootieContract.Presenter presenter) {
        this.mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onRefresh() {
        mPresenter.requestLoadStootie(true);
    }
}
