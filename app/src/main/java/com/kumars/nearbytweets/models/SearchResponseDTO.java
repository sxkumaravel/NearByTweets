package com.kumars.nearbytweets.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 8/31/18.
 *
 * @author kumars
 */
public class SearchResponseDTO {

    @SerializedName("statuses")
    private List<StatusesItem> items;

    public List<StatusesItem> getItems() {
        return items;
    }

    public void setItems(List<StatusesItem> items) {
        this.items = items;
    }
}
