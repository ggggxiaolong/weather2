package com.example.mrtan.weather.data.model;

import org.immutables.value.Value;

/**
 * 时段天气
 */
@Value.Immutable(copy = false)
@Value.Style(allParameters = true)
public abstract class Segment implements SegmentModel{
    public static final SegmentModel.Creator<ImmutableSegment> CREATOR = ImmutableSegment::of;
    public static final SegmentModel.Factory<ImmutableSegment> FACTORY = new Factory<>(CREATOR);
}
