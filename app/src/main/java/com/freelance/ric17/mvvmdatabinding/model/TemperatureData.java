package com.freelance.ric17.mvvmdatabinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.freelance.ric17.mvvmdatabinding.BR;

public class TemperatureData extends BaseObservable implements Parcelable {

    private String location;
    private String celsius;
    public String url = "http://lorempixel.com/400/200/";

    public TemperatureData(String location, String celsius) {
        this.location = location;
        this.celsius = celsius;
    }


    protected TemperatureData(Parcel in) {
        location = in.readString();
        celsius = in.readString();
        url = in.readString();
    }

    public static final Creator<TemperatureData> CREATOR = new Creator<TemperatureData>() {
        @Override
        public TemperatureData createFromParcel(Parcel in) {
            return new TemperatureData(in);
        }

        @Override
        public TemperatureData[] newArray(int size) {
            return new TemperatureData[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(location);
        parcel.writeString(celsius);
        parcel.writeString(url);
    }
    @Override
    public String toString() {
        return "TemperatureData{" +
                "location='" + location + '\'' +
                ", celsius='" + celsius + '\'' +
                ", url='" + url + '\'' +
                '}';
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
