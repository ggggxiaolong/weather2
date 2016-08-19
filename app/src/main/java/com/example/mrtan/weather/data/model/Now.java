package com.example.mrtan.weather.data.model;

import org.immutables.value.Value;

/**
 * 实时情况
 */
@Value.Immutable(copy = false)
@Value.Style(allParameters = true)
public abstract class Now implements NowModel{

    static final Creator<Now> CREATOR = ImmutableNow ::of;

    public static final Factory<Now> FACTORY = new Factory<>(CREATOR);
}
