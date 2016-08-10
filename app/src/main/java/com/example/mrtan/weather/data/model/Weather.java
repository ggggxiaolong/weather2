package com.example.mrtan.weather.data.model;

import java.util.List;

/**
 * 天气
 */

public final class Weather {
    private Alarm mAlarm;//警告
    private Now mNow;//当前
    private List<Segment> mSegments;//时段
    private List<Quality> mQualities;//建议
    private List<Daily> mDailies;//每天
}
