package com.kumars.nearbytweets.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 8/31/18.
 *
 * @author kumars
 */
public class StatusesItem {

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("source")
    private String source;

    @SerializedName("retweet_count")
    private int retweetCount;

    @SerializedName("retweeted")
    private boolean retweeted;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("favorite_count")
    private int favoriteCount;

    @SerializedName("id")
    private long id;

    @SerializedName("text")
    private String text;

    @SerializedName("user")
    private User user;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
