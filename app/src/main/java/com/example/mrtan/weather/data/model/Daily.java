package com.example.mrtan.weather.data.model;

import android.support.annotation.IdRes;

import org.immutables.value.Value;

/**
 * 每日天气
 */
@Value.Immutable(copy = false)
@Value.Style(allParameters = true)
public abstract class Daily implements DailyModel{
    public static final DailyModel.Creator<ImmutableDaily> CREATOR = ImmutableDaily :: of;
    public static final DailyModel.Factory<ImmutableDaily> FACTORY = new Factory<>(CREATOR);
}
