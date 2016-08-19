package com.example.mrtan.weather.data.model;

import android.support.annotation.Nullable;

import org.immutables.value.Value;

/**
 * *预警消息
 */
@Value.Immutable(copy = false)
@Value.Style(allParameters = true)
public abstract class Alarm implements AlarmModel{
    public static final AlarmModel.Creator CREATOR = ImmutableAlarm :: of;
    public static final AlarmModel.Factory FACTORY = new Factory(CREATOR);
}
