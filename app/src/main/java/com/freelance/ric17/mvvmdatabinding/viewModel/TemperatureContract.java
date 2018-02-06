package com.freelance.ric17.mvvmdatabinding.viewModel;


import com.freelance.ric17.mvvmdatabinding.model.TemperatureData;

public interface TemperatureContract {
    void showData(TemperatureData temperatureData);
    void startSecondActivity();
}
