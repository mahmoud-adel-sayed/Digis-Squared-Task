package com.digis.android.task;

import android.app.Activity;
import android.app.Application;

import com.digis.android.task.di.AppInjector;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
        Stetho.initializeWithDefaults(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mActivityInjector;
    }
}
