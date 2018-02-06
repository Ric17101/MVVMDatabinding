package com.freelance.ric17.mvvmdatabinding.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.freelance.ric17.mvvmdatabinding.BR;


public class TemperatureData_ extends BaseObservable {
    private String location;
    private String celsius;
    public String url = "http://lorempixel.com/400/200/";

    public TemperatureData_(String location, String celsius) {
        this.location = location;
        this.celsius = celsius;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public  void setLocation(String location){
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }

}
