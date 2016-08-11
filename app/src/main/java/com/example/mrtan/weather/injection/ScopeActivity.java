package com.example.mrtan.weather.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
/**
 * 用于区分对象的生存域
 */
public @interface ScopeActivity {

}
