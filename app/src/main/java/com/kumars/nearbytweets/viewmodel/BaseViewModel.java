package com.kumars.nearbytweets.viewmodel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class BaseViewModel<T extends IView> {

    CompositeDisposable compositeDisposable;
    T view;

    BaseViewModel() {
        compositeDisposable = new CompositeDisposable();
    }

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void clearSubscriptions() {
        compositeDisposable.clear();
    }
}
