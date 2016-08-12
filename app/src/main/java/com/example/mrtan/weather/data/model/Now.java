package com.example.mrtan.weather.data.model;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import org.immutables.value.Value;

/**
 * 实时情况
 */
@Value.Immutable(copy = false)
@Value.Style(allParameters = true)
public abstract class Now implements NowModel{

    /*static Creator<Now> CREATOR = new Creator<Now>() {
        @Override
        public Now create(@Nullable String cid, @Nullable Integer icon, @Nullable String _desc, @Nullable String fl, @Nullable String _temp, @Nullable String hum, @Nullable String pcpm, @Nullable String sc, @Nullable String spd, @Nullable String pm25, @Nullable String quality) {
            return ImmutableNow::of;
        }
    };

    public static Factory<Now> FACTORY = new Factory<>(CREATOR);*/
}
