package com.kelvinhado.stootie.stootie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kelvinhado.stootie.R;
import com.kelvinhado.stootie.data.Injection;
import com.kelvinhado.stootie.utils.ActivityUtils;

/**
 * Created by kelvin on 16/10/2017.
 */

public class StootieActivity extends AppCompatActivity {

    private StootieFragment mFragment;

    private StootiePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stootie);

        String stootieId = getIntent().getStringExtra(Intent.EXTRA_UID);

        // use saved fragment instance if available
        if(savedInstanceState != null) {
            mFragment = (StootieFragment) getSupportFragmentManager().getFragment(savedInstanceState, "savedFragmentStootie");
        } else {
            mFragment = (StootieFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        }

        if (mFragment == null) {
            // Create the fragment
            mFragment = StootieFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFragment, R.id.content_frame);
        }

        // add presenter
        mPresenter = new StootiePresenter(Injection.providePicturesRepository(this), mFragment);
        mPresenter.requestLoadStootie(stootieId, false);

    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "savedFragmentStootie", mFragment);
    }
}
