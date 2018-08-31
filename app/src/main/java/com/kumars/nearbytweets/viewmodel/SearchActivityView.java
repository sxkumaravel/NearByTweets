package com.kumars.nearbytweets.viewmodel;

import com.kumars.nearbytweets.models.StatusesItem;

import java.util.List;

/**
 * Created on 8/31/18.
 *
 * @author kumars
 */
public interface SearchActivityView extends IView {

    void showSearchResult(List<StatusesItem> statusesItems);
}
