package com.kumars.nearbytweets.viewmodel;

import com.kumars.nearbytweets.api.TwitterApi;
import com.kumars.nearbytweets.models.SearchResponseDTO;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created on 8/31/18.
 *
 * @author kumars
 */
public class SearchActivityViewModel extends BaseViewModel<SearchActivityView> {

    private TwitterApi twitterApi;
    private Disposable searchDisposable;

    public SearchActivityViewModel(TwitterApi twitterApi) {
        this.twitterApi = twitterApi;
    }

    public void searchTweets(String searchString) {
        if (searchDisposable != null) {
            searchDisposable.dispose();
        }
        searchDisposable = twitterApi.searchTweets(searchString)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(SearchResponseDTO::getItems)
                .subscribe(searchResponse -> view.showSearchResult(searchResponse), throwable -> view.error(throwable));
    }
}
