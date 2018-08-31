package com.kumars.nearbytweets.di.module;

import com.kumars.nearbytweets.api.TwitterApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created on 8/26/18.
 *
 * @author kumars
 */
@Module
public class TwitterModule {

    @Provides
    @Singleton
    TwitterApi provideRetrofit(Retrofit retrofit) {
        return retrofit.create(TwitterApi.class);
    }
}
