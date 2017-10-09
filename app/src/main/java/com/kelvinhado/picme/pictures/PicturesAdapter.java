package com.kelvinhado.picme.pictures;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kelvinhado.picme.R;
import com.kelvinhado.picme.data.source.Picture;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kelvin on 09/10/2017.
 */

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.PictureViewHolder> {

    private List<Picture> mDataset;

    private ListItemClickListener mListener;

    public PicturesAdapter(List<Picture> pictureList, ListItemClickListener listener) {
        mDataset = pictureList;
        mListener = listener;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pictures_list_item, parent, false);
        return new PicturesAdapter.PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture = mDataset.get(position);
        holder.itemView.setTag(picture.getId());
        holder.bind(picture);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface ListItemClickListener {
        void onListItemClicked(int itemPosition);
    }

    class PictureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_item_name)
        TextView title;

        public PictureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(Picture picture) {
            title.setText(picture.getTitle());
        }

        @Override
        public void onClick(View view) {
            mListener.onListItemClicked(getAdapterPosition());
        }
    }

}
