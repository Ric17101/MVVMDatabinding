package com.freelance.ric17.mvvmdatabinding.viewModel;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;
import android.databinding.ObservableParcelable;
import android.util.Log;

import com.freelance.ric17.mvvmdatabinding.model.TemperatureData;

public class TemperatureViewModel implements ViewModel {

    private static final String TAG = TemperatureViewModel.class.getSimpleName();
    public final ObservableParcelable<TemperatureData> observableModel = new ObservableParcelable<>();
    public TemperatureData model;

    public final ObservableArrayMap<String, String> cells = new ObservableArrayMap<>();
    public final ObservableField<String> winner = new ObservableField<>();

    public TemperatureViewModel() {
        model = new TemperatureData("Hamburgs", "10");
        observableModel.set(model);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onResetSelected() {
        //observableModel.restart();
        winner.set(null);
        cells.clear();
    }

    int x = 0;
    public void setTemperature(TemperatureData data) {
        //Player playerThatMoved = observableModel.mark(row, col);
        //cells.put("" + row + col, playerThatMoved == null ? null : playerThatMoved.toString());
        //winner.set(observableModel.getWinner() == null ? null : observableModel.getWinner().toString());
        model.setCelsius(data.getCelsius() + x);
        x++;
        model.setLocation("TEST" + x);
        Log.d(TAG, data.toString());
    }

    /*@Override
    public void showData(TemperatureData temperatureData) {

    }

    @Override
    public void startSecondActivity() {

    }*/
}
