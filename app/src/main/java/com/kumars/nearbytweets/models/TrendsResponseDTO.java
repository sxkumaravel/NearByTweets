package com.kumars.nearbytweets.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class TrendsResponseDTO {

    @SerializedName("trends")
    public List<TrendsItem> trends;

    public List<TrendsItem> getTrends() {
        return trends;
    }

    public void setTrends(List<TrendsItem> trends) {
        this.trends = trends;
    }
}
