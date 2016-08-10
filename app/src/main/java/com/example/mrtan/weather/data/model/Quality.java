package com.example.mrtan.weather.data.model;

/**
 * *生活指数
 */

public final class Quality implements Comparable<Quality>{
    String title;
    String brief;
    String detail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int compareTo(Quality o) {
        return 0;
    }
}
