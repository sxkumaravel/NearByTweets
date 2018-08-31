package com.kumars.nearbytweets.api;

import com.kumars.nearbytweets.models.SearchResponseDTO;
import com.kumars.nearbytweets.models.TrendsResponseDTO;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
public interface TwitterApi {

    @GET("/1.1/trends/place.json")
    Observable<List<TrendsResponseDTO>> getTrends(@Query("id") String placeId);

    @GET("/1.1/search/tweets.json")
    Flowable<SearchResponseDTO> searchTweets(@Query("q") String query);
}
