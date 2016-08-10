package com.example.mrtan.weather.data.model;

import java.util.Collections;
import java.util.List;

/**
 * 天气
 */

public final class Weather {
    private List<Alarm> mAlarms;//警告
    private Now mNow;//当前
    private List<Segment> mSegments;//时段
    private List<Quality> mQualities;//建议
    private List<Daily> mDailies;//每天

    public List<Alarm> getAlarm() {
        return mAlarms;
    }

    public void setAlarm(List<Alarm> alarms) {
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
}
