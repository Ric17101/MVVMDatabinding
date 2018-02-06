package com.freelance.ric17.mvvm_recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.freelance.ric17.mvvm_recyclerview.R;
import com.freelance.ric17.mvvm_recyclerview.commands.FavImgClickHandle;
import com.freelance.ric17.mvvm_recyclerview.databinding.SportDataBinding;
import com.freelance.ric17.mvvm_recyclerview.viewModel.SportViewModel;

import java.util.ArrayList;

/**
 * Created by firstcom on 2/5/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private ArrayList<SportViewModel> mList;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(Context mContext, ArrayList<SportViewModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void addData(SportViewModel model) {
        this.mList.add(model);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        SportDataBinding dataBinding = SportDataBinding.inflate(inflater, parent, false);

        return new ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SportViewModel model =mList.get(position);
        holder.bind(model);

        final SportDataBinding dataBinding = holder.getDataBinding();
        dataBinding.setHandler(new FavImgClickHandle() {
            @Override
            public void onFavImgClick() {
                if (model.imgSrcId.get() == R.drawable.star) {
                    model.imgSrcId.set(R.drawable.star_outline);
                    Toast.makeText(mContext, "Sports removed from favorites.", Toast.LENGTH_SHORT).show();
                }else {
                    model.imgSrcId.set(R.drawable.star);
                    Toast.makeText(mContext, "Sports added to favorites.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
