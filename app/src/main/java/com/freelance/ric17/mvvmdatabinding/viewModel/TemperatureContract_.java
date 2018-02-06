package com.freelance.ric17.mvvmdatabinding.viewModel;


import com.freelance.ric17.mvvmdatabinding.model.TemperatureData;

public interface TemperatureContract_ {
    interface Presenter {
        void onShowData(TemperatureData temperatureData);
        void showList();
    }

    interface View {
        void showData(TemperatureData temperatureData);
        void startSecondActivity();
    }

}
