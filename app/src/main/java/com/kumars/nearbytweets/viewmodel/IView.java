package com.kumars.nearbytweets.viewmodel;

/**
 * View part of MVVM, the activities and fragment implement this
 * and is used for interaction between ViewModel and Activities/Fragments.
 * Created on 8/26/18.
 *
 * @author kumars
 */
public interface IView {

    void error(Throwable e);

    void error();
}
