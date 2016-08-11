package com.example.mrtan.weather.data.remote;

import com.example.mrtan.weather.data.model.Weather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 网络请求
 */

public interface Api {

    @GET("heweather/weather/free")
    Observable<Weather> queryByCity(@Query("city") String city);

    @GET("heweather/weather/free")
    Observable<Weather> queryWByIp(@Query("cityip") String cityIp);

    @GET("heweather/weather/free")
    Observable<Weather> queryWById(@Query("cityid") String cityId);
}
