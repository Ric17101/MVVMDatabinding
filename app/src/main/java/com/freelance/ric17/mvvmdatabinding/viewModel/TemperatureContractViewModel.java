package com.freelance.ric17.mvvmdatabinding.viewModel;

import com.freelance.ric17.mvvmdatabinding.model.TemperatureData;

public class TemperatureContractViewModel implements TemperatureContract {

    private static final String TAG = TemperatureContractViewModel.class.getSimpleName();
    public TemperatureData model;
    /*public final ObservableParcelable<TemperatureData> observableModel = new ObservableParcelable<>();

    public TemperatureContractViewModel() {
        model = new TemperatureData("Hamburgs", "10");
        observableModel.set(model);
    }*/

    public TemperatureContractViewModel() {

    }

    private TemperatureContract view;

    public TemperatureContractViewModel(TemperatureContract view) {
        this.view = view;
    }

    @Override
    public void showData(TemperatureData temperatureData) {

    }

    @Override
    public void startSecondActivity() {

    }

    public void testCall(){

    }
}
