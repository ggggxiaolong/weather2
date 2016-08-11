package com.example.mrtan.weather.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
/**
 * 用于区分相同返回值的不同对象
 */
public @interface ClientCache {
}
