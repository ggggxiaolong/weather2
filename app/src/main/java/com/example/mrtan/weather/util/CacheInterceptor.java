package com.example.mrtan.weather.util;

import java.io.IOException;


import javax.inject.Inject;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 缓存拦截器
 */
public final class CacheInterceptor implements Interceptor{

    private final NetworkStatus mStatus;

    @Inject
    public CacheInterceptor(NetworkStatus networkStatus){
        mStatus = networkStatus;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        Request.Builder request = originRequest.newBuilder();
        //如果请求的refresh请求头字段非空表示忽略缓存从网络拉取数据
        if (originRequest.header("refresh") != null){
            request.cacheControl(CacheControl.FORCE_NETWORK);
        }
        Response response = chain.proceed(request.build());
        return response.newBuilder()
                .removeHeader("Pragma")//http1.0 时代的产物
                .removeHeader("Cache-Control")
                .addHeader("Cache-Control", cacheControl())
                .build();
    }

    private String cacheControl() {
        if (mStatus.isGoodConnected()){
            return "public, max-age=3600";//表示缓存的实效为一小时
        } else {
            return "public, only-if-cached, max-stale=7200";//表示如果有缓存读取缓存内容,超过缓存有效期2个小时的缓存是可以使用的
        }
    }
}
