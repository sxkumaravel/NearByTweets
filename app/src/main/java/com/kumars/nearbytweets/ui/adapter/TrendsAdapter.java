package com.kumars.nearbytweets.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kumars.nearbytweets.R;
import com.kumars.nearbytweets.databinding.TrendsRowLayoutBinding;
import com.kumars.nearbytweets.models.TrendsItem;

import java.util.List;

/**
 * Created on 8/27/18.
 *
 * @author kumars
 */
public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.TrendsViewHolder> {

    private List<TrendsItem> mTrendsItems;
    private Listener mListener;

    public TrendsAdapter(Listener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public TrendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TrendsRowLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.trends_row_layout, parent, false);
        return new TrendsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendsViewHolder holder, int position) {
        TrendsItem trendsItem = mTrendsItems.get(position);
        holder.update(trendsItem);
        holder.itemView.setTag(trendsItem);
        holder.itemView.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onTrendsItemClicked((TrendsItem) view.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTrendsItems.size();
    }

    public void setTrendsItems(List<TrendsItem> trendsItems) {
        this.mTrendsItems = trendsItems;
        notifyDataSetChanged();
    }

    static class TrendsViewHolder extends RecyclerView.ViewHolder {

        TrendsRowLayoutBinding binding;

        TrendsViewHolder(TrendsRowLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void update(TrendsItem trendsItem) {
            binding.setTrend(trendsItem);
            binding.executePendingBindings();
        }
    }

    /**
     * Interface to be implemented by the caller to get the view events.
     */
    public interface Listener {

        /**
         * Method to invoke when the trends item is selected.
         *
         * @param trendsItem {@link TrendsItem}
         */
        void onTrendsItemClicked(@NonNull TrendsItem trendsItem);
    }
}
