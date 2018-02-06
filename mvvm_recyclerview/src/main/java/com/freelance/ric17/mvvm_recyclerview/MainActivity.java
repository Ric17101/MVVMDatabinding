package com.freelance.ric17.mvvm_recyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.freelance.ric17.mvvm_recyclerview.adapter.RecyclerViewAdapter;
import com.freelance.ric17.mvvm_recyclerview.commands.AddItemSport;
import com.freelance.ric17.mvvm_recyclerview.databinding.ActivityMainBinding;
import com.freelance.ric17.mvvm_recyclerview.viewModel.SportViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    RecyclerView recyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = activityMainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerViewAdapter = new RecyclerViewAdapter(this, getData());
        recyclerView.setAdapter(mRecyclerViewAdapter);

        activityMainBinding.setAddSportEvent(new AddItemSport() {
            @Override
            public void onAddSport() {
                addData();
                Toast.makeText(MainActivity.this, "Added...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addData() {
        SportViewModel model =  new SportViewModel();
        model.sportsName = "Sport" + (mRecyclerViewAdapter.getItemCount() + 1) ;
        model.imgSrcId.set(R.drawable.star_outline);
        mRecyclerViewAdapter.addData(model);
    }

    private ArrayList<SportViewModel> getData() {
        ArrayList<SportViewModel> data = new ArrayList<>();
        SportViewModel model =  new SportViewModel();

        model.sportsName = "Football";
        model.imgSrcId.set(R.drawable.star_outline);
        data.add(model);

         model =  new SportViewModel();
        model.sportsName = "Crikcet";
        model.imgSrcId.set(R.drawable.star_outline);
        data.add(model);

         model =  new SportViewModel();
        model.sportsName = "Tennis";
        model.imgSrcId.set(R.drawable.star_outline);
        data.add(model);




        return data;
    }
}
