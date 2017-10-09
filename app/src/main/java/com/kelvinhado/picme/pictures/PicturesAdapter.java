package com.kelvinhado.picme.pictures;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.kelvinhado.picme.data.source.Picture;

import java.util.List;

/**
 * Created by kelvin on 09/10/2017.
 */

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.PictureViewHolder> {

    private List<Picture> mPictureItems;

    public PicturesAdapter(List<Picture> pictureList) {
        this.mPictureItems = pictureList;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PictureViewHolder extends RecyclerView.ViewHolder  {

        public PictureViewHolder(View itemView) {
            super(itemView);
        }
    }

}
