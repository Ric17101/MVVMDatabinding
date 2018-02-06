package com.freelance.ric17.mvvmdatabinding.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.freelance.ric17.mvvmdatabinding.R;
import com.freelance.ric17.mvvmdatabinding.viewModel.TemperatureContractViewModel;
import com.freelance.ric17.mvvmdatabinding.viewModel.TemperatureViewModel;


public class TemperatureActivity extends AppCompatActivity {

    TemperatureViewModel viewModel = new TemperatureViewModel();
    TemperatureContractViewModel tempContractVM = new TemperatureContractViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(this);
        TemperatureData temperatureData = new TemperatureData("Hamburg", "10");
        binding.setTemp(temperatureData);
        binding.setPresenter(mainActivityPresenter)*/;

        //TemperatureBinding binding = DataBindingUtil.setContentView(this, R.layout.temperature);
        //binding.setViewModel(viewModel);
        //binding.set(tempContractVM);
        // binding.button.setOnClickListener(this);
        viewModel.onCreate();
    }

   /* @Override
    public void showData(TemperatureData temperatureData) {
        String celsius = temperatureData.getCelsius();
        Toast.makeText(this, celsius, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tictactoe, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
                viewModel.onResetSelected();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
