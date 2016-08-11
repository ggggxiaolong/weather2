package com.example.mrtan.weather.data.remote;

import com.example.mrtan.weather.data.model.Weather;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public final class GsonAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (Weather.class == type.getRawType()){
            return new WeatherTypeAdapter();
        }
        return null;
    }
}
