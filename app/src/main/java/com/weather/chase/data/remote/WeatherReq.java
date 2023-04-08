package com.weather.chase.data.remote;

/**
 * Created by peterx.theja on 2023-04-05.
 */
public class WeatherReq {
    private final String lat;
    private final String lon;

    public WeatherReq(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
