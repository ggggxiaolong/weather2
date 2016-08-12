package com.example.mrtan.weather.data.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * 天气
 */

public final class Weather implements WeatherModel{

    private String mCityId;
    private String mCityName;
    private List<Alarm> mAlarms;//警告
    private Now mNow;//当前
    private List<Segment> mSegments;//时段
    private List<Quality> mQualities;//建议
    private List<Daily> mDailies;//每天

    public String getCityId() {
        return mCityId;
    }

    public void setCityId(String cityId) {
        mCityId = cityId;
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    public List<Alarm> getAlarms() {
        return mAlarms;
    }

    public void setAlarms(List<Alarm> alarms) {
        mAlarms = alarms;
    }

    public Now getNow() {
        return mNow;
    }

    public void setNow(Now now) {
        mNow = now;
    }

    public List<Segment> getSegments() {
        return mSegments;
    }

    public void setSegments(List<Segment> segments) {
        mSegments = segments;
    }

    public List<Quality> getQualities() {
        return mQualities;
    }

    public void setQualities(List<Quality> qualities) {
        mQualities = qualities;
    }

    public List<Daily> getDailies() {
        return mDailies;
    }

    public void setDailies(List<Daily> dailies) {
        mDailies = dailies;
    }

    @Nullable
    @Override
    public String cid() {
        return mCityId;
    }

    @NonNull
    @Override
    public String cname() {
        return mCityName;
    }

}
