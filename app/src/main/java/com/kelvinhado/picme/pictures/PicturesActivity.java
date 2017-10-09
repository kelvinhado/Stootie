package com.kelvinhado.picme.pictures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kelvinhado.picme.R;
import com.kelvinhado.picme.utils.ActivityUtils;

public class PicturesActivity extends AppCompatActivity {

    private PicturesPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        PicturesFragment picturesFragment =
                (PicturesFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (picturesFragment == null) {
            // Create the fragment
            picturesFragment = PicturesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), picturesFragment, R.id.content_frame);
        }

        // add presenter
        mPresenter = new PicturesPresenter(picturesFragment);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
