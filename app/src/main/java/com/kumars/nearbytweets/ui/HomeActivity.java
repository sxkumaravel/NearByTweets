package com.kumars.nearbytweets.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.kumars.nearbytweets.R;
import com.kumars.nearbytweets.TwitterApplication;
import com.kumars.nearbytweets.api.TwitterApi;
import com.kumars.nearbytweets.databinding.ActivityHomeBinding;
import com.kumars.nearbytweets.models.TrendsItem;
import com.kumars.nearbytweets.ui.adapter.TrendsAdapter;
import com.kumars.nearbytweets.viewmodel.HomeActivityView;
import com.kumars.nearbytweets.viewmodel.HomeActivityViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Activity to show the list of tweets.
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeActivityViewModel> implements HomeActivityView, TrendsAdapter.Listener {

    @Inject
    TwitterApi mTwitterApi;

    private TrendsAdapter mTrendsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterApplication.getAppComponent().inject(this);

        mViewModel = new HomeActivityViewModel(mTwitterApi);
        mViewModel.attach(this);

        bindView(R.layout.activity_home);
        mBinding.setIsLoading(true);

        mTrendsAdapter = new TrendsAdapter(this);
        mBinding.trends.setAdapter(mTrendsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // hard code san francisco for now
        mViewModel.fetchTrends("1"); // TODO: I couldn't easily find the free woeid api - so that I can use the location to get the WOEID and intern use it in this twitter api.
    }

    @Override
    public void load(List<TrendsItem> items) {
        mBinding.setIsLoading(false);
        mTrendsAdapter.setTrendsItems(items);
    }

    @Override
    public void onTrendsItemClicked(@NonNull TrendsItem trendsItem) {
        SearchActivity.openActivity(this, trendsItem.getQuery());
    }
}
