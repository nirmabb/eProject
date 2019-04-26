package com.example.familyphotoeducationapp.lifecycle;

import android.app.Application;

import com.example.familyphotoeducationapp.lifecycle.ActivityLifecycle;

public class ApplicationWrapper extends Application {

    public static long startTime = System.currentTimeMillis();


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycle());

    }
}
