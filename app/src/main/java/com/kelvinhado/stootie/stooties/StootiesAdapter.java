package com.kelvinhado.stootie.stooties;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kelvinhado.stootie.R;
import com.kelvinhado.stootie.data.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kelvin on 09/10/2017.
 */

public class StootiesAdapter extends RecyclerView.Adapter<StootiesAdapter.PictureViewHolder> {

    private List<Picture> mDataset;

    private ListItemClickListener mListener;

    private Context mContext;

    public StootiesAdapter(Context context, List<Picture> pictureList, ListItemClickListener listener) {
        mDataset = pictureList;
        mListener = listener;
        mContext = context;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pictures_list_item, parent, false);
        return new StootiesAdapter.PictureViewHolder(view);
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

    public void swap(List<Picture> list){
        if (mDataset != null) {
            mDataset.clear();
            mDataset.addAll(list);
        }
        else {
            mDataset = list;
        }
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onListItemClicked(int itemPosition);
    }

    class PictureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_item_name)
        TextView title;
        @BindView(R.id.iv_item_thumbnail)
        ImageView thumbnail;

        public PictureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(Picture picture) {
            title.setText(picture.getTitle());
            // downloading and caching images using Picasso
            Picasso.with(mContext)
                    .load(picture.getThumbnailUrl())
                    .placeholder(ContextCompat.getDrawable(mContext, R.drawable.default_place_holder))
                    .into(thumbnail);
        }

        @Override
        public void onClick(View view) {
            mListener.onListItemClicked(getAdapterPosition());
        }
    }

}
