package com.example.mrtan.weather.injection.module;

import android.app.Application;

import com.example.mrtan.weather.injection.ClientCache;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Module
public final class NetWorkModel {

    @Singleton
    @Provides
    OkHttpClient provideClient(@ClientCache File cacheDir){
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //不能在这里使用缓存，因为不能通过时间来使缓存失效
        //Cache cache = new Cache(cacheDir, 20*1024*1024);
        //todo
        return null;
    }

    @Provides
    @Singleton
    @ClientCache
    File provideCacheFile(Application application){
        return new File(application.getCacheDir(), "cache_file");
    }
}
