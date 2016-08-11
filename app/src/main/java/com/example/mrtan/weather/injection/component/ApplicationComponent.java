package com.example.mrtan.weather.injection.component;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface ApplicationComponent {

    void inject(@NonNull Application application);
}
