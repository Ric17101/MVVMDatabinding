package com.freelance.ric17.mvvmdatabinding.adapter;


import com.freelance.ric17.mvvmdatabinding.R;
import com.freelance.ric17.mvvmdatabinding.model.TemperatureData;

import java.util.List;

public class MyAdapter extends MyBaseAdapter {
        private List<TemperatureData> data;

        public MyAdapter(List<TemperatureData> myDataset) {
                data = myDataset;
        }

        @Override
        public Object getDataAtPosition(int position) {
                return data.get(position);
        }

        @Override
        public int getLayoutIdForType(int viewType) {
                return R.layout.rowlayout;
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
                return data.size();
        }

}