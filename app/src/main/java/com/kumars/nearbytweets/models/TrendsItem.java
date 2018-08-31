package com.kumars.nearbytweets.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class TrendsItem {

    @SerializedName("query")
    private String query;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
