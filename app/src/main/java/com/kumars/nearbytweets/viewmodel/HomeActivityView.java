package com.kumars.nearbytweets.viewmodel;

import com.kumars.nearbytweets.models.TrendsItem;

import java.util.List;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
public interface HomeActivityView extends IView {

    void load(List<TrendsItem> items);
}
