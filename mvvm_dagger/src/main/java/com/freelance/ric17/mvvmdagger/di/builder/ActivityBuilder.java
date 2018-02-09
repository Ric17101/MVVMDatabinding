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

package com.freelance.ric17.mvvmdagger.di.builder;

import com.freelance.ric17.mvvmdagger.ui.about.AboutFragmentProvider;
import com.freelance.ric17.mvvmdagger.ui.feed.FeedActivity;
import com.freelance.ric17.mvvmdagger.ui.feed.FeedActivityModule;
import com.freelance.ric17.mvvmdagger.ui.feed.blogs.BlogFragmentProvider;
import com.freelance.ric17.mvvmdagger.ui.feed.opensource.OpenSourceFragmentProvider;
import com.freelance.ric17.mvvmdagger.ui.login.LoginActivity;
import com.freelance.ric17.mvvmdagger.ui.login.LoginActivityModule;
import com.freelance.ric17.mvvmdagger.ui.main.MainActivity;
import com.freelance.ric17.mvvmdagger.ui.main.MainActivityModule;
import com.freelance.ric17.mvvmdagger.ui.main.rating.RateUsDialogProvider;
import com.freelance.ric17.mvvmdagger.ui.splash.SplashActivity;
import com.freelance.ric17.mvvmdagger.ui.splash.SplashActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {MainActivityModule.class,
            AboutFragmentProvider.class, RateUsDialogProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {FeedActivityModule.class,
            BlogFragmentProvider.class, OpenSourceFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

}
