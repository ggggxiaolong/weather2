package com.example.mrtan.weather.data.remote;

import com.example.mrtan.weather.data.model.Alarm;
import com.example.mrtan.weather.data.model.Daily;
import com.example.mrtan.weather.data.model.Now;
import com.example.mrtan.weather.data.model.Quality;
import com.example.mrtan.weather.data.model.Segment;
import com.example.mrtan.weather.data.model.Weather;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 天气的TypeAdapter
 */

public class WeatherTypeAdapter<T> {
/*
    @Override
    public void write(JsonWriter out, Weather value) throws IOException {

    }

    @Override
    public Weather read(JsonReader in) throws IOException {
        in.beginObject();
        if (in.hasNext() && in.nextName().equals("HeWeather data service 3.0")) {
            in.beginArray();
            if (in.hasNext()) {
                final Weather weather = new Weather();
                do {
                    switch (in.nextName()) {
                        case "aqi": {
                            resolveApi(in, weather);
                            break;
                        }
                        case "daily_forecast": {
                            resolveDaily(in, weather);
                            break;
                        }
                        case "hourly_forecast": {
                            resolveHourly(in, weather);
                            break;
                        }
                        case "alarms": {
                            resolveAlarms(in, weather);
                            break;
                        }
                        case "now": {
                            resolveNow(in, weather);
                            break;
                        }
                        case "suggestion": {
                            resolveSuggestion(in, weather);
                            break;
                        }
                    }
                } while (in.hasNext());
                in.endArray();
                in.endObject();
                return weather;
            } else {
                in.endArray();
                in.endObject();
                return null;
            }
        } else {
            in.endObject();
            return null;
        }
    }

    *//**
     * 处理建议
     *//*
    private void resolveSuggestion(JsonReader in, Weather weather) throws IOException {
        ArrayList<Quality> qs = new ArrayList<>();//小于10个,不用显示声明个数
        in.beginObject();
        while (in.hasNext()) {
            Quality q = new Quality();
            switch (in.nextName()) {
                case "comf": {
                    q.setOrder(0);
                    q.setTitle("舒适指数");
                    break;
                }
                case "sport": {
                    q.setOrder(4);
                    q.setTitle("运动指数");
                    break;
                }
                case "uv": {
                    q.setOrder(2);
                    q.setTitle("紫外线指数");
                    break;
                }
                case "trav": {
                    q.setOrder(5);
                    q.setTitle("旅游指数");
                    break;
                }
                case "cw": {
                    q.setOrder(6);
                    q.setTitle("洗车指数");
                    break;
                }
                case "flu": {
                    q.setOrder(3);
                    q.setTitle("健康指数");
                    break;
                }
                case "drsg": {
                    q.setOrder(1);
                    q.setTitle("穿衣指数");
                    break;
                }
            }
            q.setTitle(in.nextName());
            in.beginObject();
            while (in.hasNext()) {
                if ("brf".equals(in.nextName())) {
                    q.setBrief(in.nextString());
                } else {
                    q.setDetail(in.nextString());
                }
            }
            in.endObject();
            qs.add(q);
        }
        in.endObject();
        if (qs.size() > 0) {
            //将建议进行排序
            Collections.sort(qs);
            weather.setQualities(qs);
        }
    }

    *//*
     * 处理实时天气
     *//*
    private void resolveNow(JsonReader in, Weather weather) throws IOException {
        in.beginObject();
        Now now = weather.getNow();
        if (in.hasNext()) {
            if (now == null) {
                now = new Now();
                weather.setNow(now);
            }
        }
        do {
            switch (in.nextName()) {
                case "cond": {
                    in.beginObject();
                    while (in.hasNext()) {
                        if ("txt".equals(in.nextName())) {
                            now.setDesc(in.nextString());
                        } else {
                            // todo
                        }
                    }
                    in.endObject();
                    break;
                }
                case "fl": {
                    now.setFl(in.nextString());
                    break;
                }
                case "tmp": {
                    now.setTemp(in.nextString());
                    break;
                }
                case "hum": {
                    now.setHum(in.nextString());
                    break;
                }
                case "pcpn": {
                    now.setPcpn(in.nextString());
                    break;
                }
                case "wind": {
                    in.beginObject();
                    while (in.hasNext()) {
                        if ("sc".equals(in.nextName())) {
                            now.setSc(in.nextString());
                        } else if ("spd".equals(in.nextName())) {
                            now.setSpd(in.nextString());
                        }
                    }
                    in.endObject();
                    break;
                }
            }
        } while (in.hasNext());
        in.endObject();
    }

    *//**
     * 处理警告
     *//*
    private void resolveAlarms(JsonReader in, Weather weather) throws IOException {
        ArrayList<Alarm> alarms = new ArrayList<>();
        in.beginArray();
        while (in.hasNext()) {
            Alarm a = new Alarm();
            in.beginObject();
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "level": {
                        a.setLevel(in.nextString());
                        break;
                    }
                    case "type": {
                        a.setType(in.nextString());
                        break;
                    }
                    case "txt": {
                        a.setDetail(in.nextString());
                        break;
                    }
                }
                alarms.add(a);
            }
            in.endObject();
        }
        in.endArray();
        if (alarms.size() > 0) {
            weather.setAlarms(alarms);
        }
    }

    *//**
     * 处理小时天气
     *//*
    private void resolveHourly(JsonReader in, Weather weather) throws IOException {
        ArrayList<Segment> segments = new ArrayList<>();
        in.beginArray();
        while (in.hasNext()) {
            Segment s = new Segment();
            in.beginObject();
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "date": {
                        String time = in.nextString();
                        s.setDate(time.substring(time.indexOf(' ') + 1));
                        break;
                    }
                    case "hum": {
                        s.setHum(in.nextString());
                        break;
                    }
                    case "tmp": {
                        s.setTemp(in.nextString());
                        break;
                    }
                    case "wind": {
                        in.beginObject();
                        while (in.hasNext()){
                            switch (in.nextName()){
                                case "sc":{
                                    s.setSc(in.nextString());
                                    break;
                                }
                                case "spd":{
                                    s.setSpd(in.nextString());
                                    break;
                                }
                            }
                        }
                        in.endObject();
                        break;
                    }
                    case "basic":{
                        in.beginObject();
                        while (in.hasNext()){
                            switch (in.nextName()){
                                case "city":{
                                    weather.setCityName(in.nextString());
                                    break;
                                }
                                case "id":{
                                    weather.setCityId(in.nextString());
                                    break;
                                }
                            }
                        }
                        in.endObject();
                    }
                }
            }
            in.endObject();
            segments.add(s);
        }
        in.endArray();
        if (segments.size()>0){
            weather.setSegments(segments);
        }
    }

    *//**
     * 处理7日天气
     *//*
    private void resolveDaily(JsonReader in, Weather weather) throws IOException {
        in.beginArray();
        ArrayList<Daily> dailies = new ArrayList<>();
        while (in.hasNext()){
            Daily d = new Daily();
            switch (in.nextName()){
                case "date":{
                    d.setDate(in.nextString());
                    break;
                }
                case "cond":{
                    in.beginObject();
                    while (in.hasNext()){
                        switch (in.nextName()){
                            case "txt_d":{
                                d.setDesc(in.nextString());
                                break;
                            }
                            case "code_d":{
                                //todo
                                break;
                            }
                        }
                    }
                    in.endObject();
                    break;
                }
                case "tmp":{
                    in.beginObject();
                    while (in.hasNext()){
                        switch (in.nextName()){
                            case "max":{
                                d.setMaxTemp(in.nextString());
                                break;
                            }
                            case "min":{
                                d.setMinTemp(in.nextString());
                                break;
                            }
                        }
                    }
                    in.endObject();
                    break;
                }
                case "hum":{
                    d.setHum(in.nextString());
                    break;
                }
                case "wind":{
                    in.beginObject();
                    while (in.hasNext()){
                        switch (in.nextName()){
                            case "sc":{
                                d.setSc(in.nextString());
                                break;
                            }
                            case "spd":{
                                d.setSpd(in.nextString());
                                break;
                            }
                        }
                    }
                    in.endObject();
                    break;
                }

            }
            dailies.add(d);
        }
        in.endArray();
        if (dailies.size()>0){
            weather.setDailies(dailies);
        }
    }

    *//**
     * 处理提天气质量
     *//*
    private void resolveApi(JsonReader in, Weather weather) throws IOException {
        in.beginObject();
        if (in.hasNext() && "city".equals(in.nextName())) {
            in.beginObject();
            Now now = weather.getNow();
            if (now == null) {
                now = new Now();
                weather.setNow(now);
            }
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "pm25": {
                        now.setPm25(in.nextString());
                        break;
                    }
                    case "qlty": {
                        now.setQuality(in.nextString());
                        break;
                    }
                }
            }
            in.endObject();
        }
        in.endObject();
    }*/
}
