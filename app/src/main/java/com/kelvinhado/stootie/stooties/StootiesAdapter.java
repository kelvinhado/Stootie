package com.kelvinhado.stootie.stooties;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kelvinhado.stootie.R;
import com.kelvinhado.stootie.data.model.Stootie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kelvin on 09/10/2017.
 */

public class StootiesAdapter extends RecyclerView.Adapter<StootiesAdapter.StootieViewHolder> {

        private List<Stootie> mDataset;

    private ListItemClickListener mListener;

    private Context mContext;

    public StootiesAdapter(Context context, List<Stootie> stootieList, ListItemClickListener listener) {
        mDataset = stootieList;
        mListener = listener;
        mContext = context;
    }

    @Override
    public StootieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_stooties, parent, false);
        return new StootiesAdapter.StootieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StootieViewHolder holder, int position) {
        Stootie stootie = mDataset.get(position);
        holder.itemView.setTag(stootie.getId());
        holder.bind(stootie);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void swap(List<Stootie> list){
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

    class StootieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_item_title)           TextView title;
        @BindView(R.id.tv_item_user_firstname)  TextView firstname;
        @BindView(R.id.tv_item_user_lastname)   TextView lastname;
        @BindView(R.id.tv_item_price)           TextView price;
        @BindView(R.id.tv_item_address)         TextView address;
        @BindView(R.id.tv_item_date)            TextView date;

        public StootieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(Stootie stootie) {
            title.setText(stootie.getTitle());
            firstname.setText(stootie.getUserFirstName());
            lastname.setText(stootie.getUserLastName());
            price.setText(Double.toString(stootie.getPrice()));
            address.setText(stootie.getAddress());
            date.setText(stootie.getCreationDate());
        }

        @Override
        public void onClick(View view) {
            mListener.onListItemClicked(getAdapterPosition());
        }
    }

}
