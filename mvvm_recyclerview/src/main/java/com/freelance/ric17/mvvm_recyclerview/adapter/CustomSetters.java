package com.freelance.ric17.mvvm_recyclerview.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageButton;

/**
 * Created by firstcom on 2/5/2018.
 */

public class CustomSetters {

    @BindingAdapter("imgSrc")
    public static void setImgSrc(ImageButton view, int resId) {
        view.setImageDrawable(view.getContext().getDrawable(resId));
        // Here you can load thee drawable with Glide or any other lib for better performance
    }

}
