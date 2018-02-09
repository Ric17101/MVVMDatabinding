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

package com.freelance.ric17.mvvmdagger.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.freelance.ric17.mvvmdagger.BuildConfig;
import com.freelance.ric17.mvvmdagger.R;
import com.freelance.ric17.mvvmdagger.data.AppDataManager;
import com.freelance.ric17.mvvmdagger.data.DataManager;
import com.freelance.ric17.mvvmdagger.data.local.db.AppDatabase;
import com.freelance.ric17.mvvmdagger.data.local.db.AppDbHelper;
import com.freelance.ric17.mvvmdagger.data.local.db.DbHelper;
import com.freelance.ric17.mvvmdagger.data.local.prefs.AppPreferencesHelper;
import com.freelance.ric17.mvvmdagger.data.local.prefs.PreferencesHelper;
import com.freelance.ric17.mvvmdagger.data.remote.ApiHeader;
import com.freelance.ric17.mvvmdagger.data.remote.ApiHelper;
import com.freelance.ric17.mvvmdagger.data.remote.AppApiHelper;
import com.freelance.ric17.mvvmdagger.di.ApiInfo;
import com.freelance.ric17.mvvmdagger.di.DatabaseInfo;
import com.freelance.ric17.mvvmdagger.di.PreferenceInfo;
import com.freelance.ric17.mvvmdagger.utils.AppConstants;
import com.freelance.ric17.mvvmdagger.utils.rx.AppSchedulerProvider;
import com.freelance.ric17.mvvmdagger.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
