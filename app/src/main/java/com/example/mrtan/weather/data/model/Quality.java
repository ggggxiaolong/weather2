package com.example.mrtan.weather.data.model;

import org.immutables.value.Value;

/**
 * *生活指数
 */
@Value.Immutable(copy = false)
@Value.Style(allParameters = true)
public abstract class Quality implements QualityModel, Comparable<Quality> {

    public static final QualityModel.Creator<ImmutableQuality> CREATOR = ImmutableQuality::of;
    public static final QualityModel.Factory<ImmutableQuality> FACTORY = new Factory<>(CREATOR);

    @Override
    public int compareTo(Quality o) {
        return _order() - o._order();
    }
}
