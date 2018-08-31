package com.kumars.nearbytweets.viewmodel;

import com.kumars.nearbytweets.api.TwitterApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class HomeActivityViewModel extends BaseViewModel<HomeActivityView> {

    private TwitterApi twitterApi;

    public HomeActivityViewModel(TwitterApi twitterApi) {
        this.twitterApi = twitterApi;
    }

    public void fetchTrends(String locationId) {
        compositeDisposable.add(twitterApi.getTrends(locationId)
                .subscribeOn(Schedulers.computation())
                .map(trendsResponses -> trendsResponses.get(0))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trendsResponse -> view.load(trendsResponse.getTrends()),
                        throwable -> view.error(throwable)));
    }
}
