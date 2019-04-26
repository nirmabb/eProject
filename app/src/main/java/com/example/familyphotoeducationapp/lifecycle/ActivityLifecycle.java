package com.example.familyphotoeducationapp.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class ActivityLifecycle implements Application.ActivityLifecycleCallbacks {


    int depth = 0;


    private String getActivityName(Activity activity){
        return activity.getClass().getSimpleName();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.d(getActivityName(activity), "onActivityCreated()");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.d(getActivityName(activity),"onActivityStarted()");
        if(depth == 0){
            //app has started
        }

        depth++;

    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d(getActivityName(activity), "onActivityResumed()");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d(getActivityName(activity), "onActivityPaused()");
    }

    @Override
    public void onActivityStopped(Activity activity) {

        Log.d(getActivityName(activity), "onActivityStopped()");
        depth--;
        if (depth == 0) {
            // Application has stopped
        }

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.d(getActivityName(activity), "onActivitySaveInstanceState()");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.d(getActivityName(activity), "onActivityDestroyed()");

    }
}
