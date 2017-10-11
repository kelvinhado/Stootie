package com.kelvinhado.picme.pictures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kelvinhado.picme.R;
import com.kelvinhado.picme.data.Injection;
import com.kelvinhado.picme.utils.ActivityUtils;

public class PicturesActivity extends AppCompatActivity {


    private PicturesFragment mFragment;

    private PicturesPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        // use saved fragment instance if available
        if(savedInstanceState != null) {
            mFragment = (PicturesFragment) getSupportFragmentManager().getFragment(savedInstanceState, "savedFragment");
        } else {
            mFragment = (PicturesFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        }

        if (mFragment == null) {
            // Create the fragment
            mFragment = PicturesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFragment, R.id.content_frame);
        }

        // add presenter
        mPresenter = new PicturesPresenter(Injection.providePicturesRepository(this), mFragment);
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "savedFragment", mFragment);
    }
}
