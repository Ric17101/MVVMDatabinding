package com.freelance.ric17.mvvm_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;

import com.freelance.ric17.mvvm_recyclerview.databinding.SportDataBinding;
import com.freelance.ric17.mvvm_recyclerview.viewModel.SportViewModel;


/**
 * Created by firstcom on 2/5/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder {


    private SportDataBinding dataBinding;

    public ViewHolder(SportDataBinding binding) {
        super(binding.getRoot());
        this.dataBinding = binding;
    }

    public void bind(SportViewModel model) {
        // dataBinding.setVariable(BR.obj,model);
        this.dataBinding.setViewModel(model);
    }


    public SportDataBinding getDataBinding() {
        return dataBinding;
    }
}