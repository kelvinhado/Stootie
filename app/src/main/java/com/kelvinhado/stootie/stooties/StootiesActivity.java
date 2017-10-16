package com.kelvinhado.stootie.stooties;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kelvinhado.stootie.R;
import com.kelvinhado.stootie.data.Injection;
import com.kelvinhado.stootie.utils.ActivityUtils;

public class StootiesActivity extends AppCompatActivity {


    private StootiesFragment mFragment;

    private StootiesPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stooties);

        // use saved fragment instance if available
        if(savedInstanceState != null) {
            mFragment = (StootiesFragment) getSupportFragmentManager().getFragment(savedInstanceState, "savedFragment");
        } else {
            mFragment = (StootiesFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        }

        if (mFragment == null) {
            // Create the fragment
            mFragment = StootiesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFragment, R.id.content_frame);
        }

        // add presenter
        mPresenter = new StootiesPresenter(Injection.providePicturesRepository(this), mFragment);
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "savedFragment", mFragment);
    }
}
