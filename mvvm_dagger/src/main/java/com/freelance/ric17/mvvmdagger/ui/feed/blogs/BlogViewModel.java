/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.freelance.ric17.mvvmdagger.ui.feed.blogs;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.freelance.ric17.mvvmdagger.data.DataManager;
import com.freelance.ric17.mvvmdagger.data.model.api.BlogResponse;
import com.freelance.ric17.mvvmdagger.ui.base.BaseViewModel;
import com.freelance.ric17.mvvmdagger.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class BlogViewModel extends BaseViewModel<BlogNavigator> {

    private final ObservableArrayList<BlogResponse.Blog> blogObservableArrayList = new ObservableArrayList<>();
    private final MutableLiveData<List<BlogResponse.Blog>> blogListLiveData;

    public BlogViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        blogListLiveData = new MutableLiveData<>();
        fetchBlogs();
    }

    public void fetchBlogs() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<BlogResponse>() {
                    @Override
                    public void accept(@NonNull BlogResponse blogResponse)
                            throws Exception {
                        if (blogResponse != null && blogResponse.getData() != null) {
                            blogListLiveData.setValue(blogResponse.getData());
                        }
                        setIsLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        setIsLoading(false);
                        getNavigator().handleError(throwable);
                    }
                }));
    }

    public MutableLiveData<List<BlogResponse.Blog>> getBlogListLiveData() {
        return blogListLiveData;
    }

    public void addBlogItemsToList(List<BlogResponse.Blog> blogs) {
        blogObservableArrayList.clear();
        blogObservableArrayList.addAll(blogs);
    }

    public ObservableArrayList<BlogResponse.Blog> getBlogObservableArrayList() {
        return blogObservableArrayList;
    }
}
