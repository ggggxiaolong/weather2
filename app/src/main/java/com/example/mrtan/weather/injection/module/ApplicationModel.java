package com.example.mrtan.weather.injection.module;

import android.app.Application;
import android.content.Context;

import com.example.mrtan.weather.data.remote.Api;
import com.example.mrtan.weather.data.remote.GsonAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModel {

    protected final Application mApplication;

    public ApplicationModel(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return mApplication;
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new GsonAdapterFactory())
                .create();
    }

    @Provides
    @Singleton
    Api provideApi(OkHttpClient client, Gson gson){
        return new Retrofit.Builder()
                .baseUrl("")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(Api.class);
    }

}
