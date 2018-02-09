package com.freelance.ric17.mvvmdagger.ui.feed;

import com.freelance.ric17.mvvmdagger.data.DataManager;
import com.freelance.ric17.mvvmdagger.ui.base.BaseViewModel;
import com.freelance.ric17.mvvmdagger.utils.rx.SchedulerProvider;

/**
 * Created by Jyoti on 29/07/17.
 */

public class FeedViewModel extends BaseViewModel {

    public FeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
