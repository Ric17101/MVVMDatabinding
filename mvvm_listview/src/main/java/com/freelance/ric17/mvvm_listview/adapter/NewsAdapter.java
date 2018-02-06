package com.freelance.ric17.mvvm_listview.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.freelance.ric17.mvvm_listview.R;
import com.freelance.ric17.mvvm_listview.databinding.ListRowBinding;
import com.freelance.ric17.mvvm_listview.viewModel.NewsModel;

import java.util.ArrayList;

/**
 * Created by firstcom on 2/5/2018.
 */

public class NewsAdapter extends ArrayAdapter<NewsModel> {
    private ArrayList<NewsModel> newsModelArrayList;
    private Context context;
    public NewsAdapter(@NonNull Context context, ArrayList<NewsModel> newsModelArrayList) {
        super(context, R.layout.list_row, newsModelArrayList);
        this.context = context;
        this.newsModelArrayList = newsModelArrayList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListRowBinding listRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_row, parent, false);
        listRowBinding.setNewsList(newsModelArrayList.get(position));


        return listRowBinding.getRoot();
    }
}
