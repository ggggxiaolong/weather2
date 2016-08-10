package com.example.mrtan.weather.data.model;

/**
 * *预警消息
 */

public final class Alarm {
    private String detail;//描述
    private String type;//类型
    private String level;//等级

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
