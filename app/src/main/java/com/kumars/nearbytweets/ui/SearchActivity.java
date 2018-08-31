package com.kumars.nearbytweets.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kumars.nearbytweets.R;
import com.kumars.nearbytweets.TwitterApplication;
import com.kumars.nearbytweets.api.TwitterApi;
import com.kumars.nearbytweets.databinding.ActivitySearchBinding;
import com.kumars.nearbytweets.models.StatusesItem;
import com.kumars.nearbytweets.ui.adapter.SearchAdapter;
import com.kumars.nearbytweets.viewmodel.SearchActivityView;
import com.kumars.nearbytweets.viewmodel.SearchActivityViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Activity to show the list of tweets.
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchActivityViewModel> implements SearchActivityView {

    private static final String EXTRA_SEARCH = "EXTRA_SEARCH";

    @Inject
    TwitterApi mTwitterApi;

    private SearchAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterApplication.getAppComponent().inject(this);

        mViewModel = new SearchActivityViewModel(mTwitterApi);
        mViewModel.attach(this);

        bindView(R.layout.activity_search);
        mBinding.setIsLoading(true);

        mAdapter = new SearchAdapter();
        mBinding.search.setAdapter(mAdapter);

        mViewModel.searchTweets(getIntent().getStringExtra(EXTRA_SEARCH));
    }

    @Override
    public void showSearchResult(List<StatusesItem> statusesItems) {
        mBinding.setIsLoading(false);
        mAdapter.setStatusesItems(statusesItems);
    }

    public static void openActivity(Context context, @NonNull String trendsItem) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra(EXTRA_SEARCH, trendsItem);
        context.startActivity(intent);
    }
}
