package com.kumars.nearbytweets.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 8/31/18.
 *
 * @author kumars
 */
public class User {

    @SerializedName("default_profile_image")
    private boolean defaultProfileImage;

    @SerializedName("favourites_count")
    private int favouritesCount;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private long id;

    @SerializedName("profile_image_url")
    private String profileImageUrl;

    public boolean isDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
