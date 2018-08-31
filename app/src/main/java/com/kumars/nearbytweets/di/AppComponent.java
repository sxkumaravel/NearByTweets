package com.kumars.nearbytweets.di;

import com.kumars.nearbytweets.ui.SearchActivity;
import com.kumars.nearbytweets.ui.HomeActivity;
import com.kumars.nearbytweets.api.RetrofitInterceptor;
import com.kumars.nearbytweets.di.module.AppModule;
import com.kumars.nearbytweets.di.module.NetworkModule;
import com.kumars.nearbytweets.di.module.TwitterModule;
import com.kumars.nearbytweets.viewmodel.HomeActivityViewModel;
import com.kumars.nearbytweets.viewmodel.SearchActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, TwitterModule.class})
public interface AppComponent {

    void inject(HomeActivity activity);

    void inject(SearchActivity activity);

    void inject(HomeActivityViewModel activity);

    void inject(RetrofitInterceptor interceptor);
}
