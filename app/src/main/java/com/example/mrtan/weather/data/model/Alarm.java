package com.example.mrtan.weather.data.model;

import android.support.annotation.Nullable;

/**
 * *预警消息
 */

public final class Alarm implements AlarmModel{
    private String cid;
    private String detail;//描述
    private String type;//类型
    private String level;//等级

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Nullable
    @Override
    public String cid() {
        return cid;
    }

    @Nullable
    @Override
    public String type() {
        return type;
    }

    @Nullable
    @Override
    public String level() {
        return level;
    }

    @Nullable
    @Override
    public String detail() {
        return detail;
    }

    public Alarm(String cid, String detail, String type, String level) {
        this.cid = cid;
        this.detail = detail;
        this.type = type;
        this.level = level;
    }

    public static Creator<Alarm> CREATOR = new Creator<Alarm>() {
        @Override
        public Alarm create(@Nullable String cid, @Nullable String type, @Nullable String level, @Nullable String detail) {
            return new Alarm(cid,type,level,detail);
        }
    };

    public static Factory<Alarm> FACTORY = new Factory<>(CREATOR);

    public Alarm(){}
}
