package com.kumars.nearbytweets.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kumars.nearbytweets.R;
import com.kumars.nearbytweets.databinding.SearchRowLayoutBinding;
import com.kumars.nearbytweets.models.StatusesItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 8/31/18.
 *
 * @author kumars
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<StatusesItem> mStatusesItems;

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SearchRowLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.search_row_layout, parent, false);
        return new SearchViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.update(mStatusesItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mStatusesItems.size();
    }

    public void setStatusesItems(List<StatusesItem> statusesItems) {
        mStatusesItems = statusesItems;
        notifyDataSetChanged();
    }

    static class SearchViewHolder extends RecyclerView.ViewHolder {

        SearchRowLayoutBinding binding;

        SearchViewHolder(SearchRowLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void update(StatusesItem searchItem) {
            binding.setSearchItem(searchItem);
            binding.executePendingBindings();
        }
    }
}
