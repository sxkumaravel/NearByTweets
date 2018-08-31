package com.kumars.nearbytweets;

import android.app.Application;

import com.kumars.nearbytweets.di.AppComponent;
import com.kumars.nearbytweets.di.DaggerAppComponent;
import com.kumars.nearbytweets.di.module.AppModule;
import com.kumars.nearbytweets.di.module.NetworkModule;
import com.kumars.nearbytweets.di.module.TwitterModule;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
public class TwitterApplication extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder()
                .twitterModule(new TwitterModule())
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
