package com.example.familyphotoeducationapp;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ApplicationCrashHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler defaultHandler;

    private static final String TAG = "ApplicationCrashHandler";


    public static void installHandler(){
        if(!(Thread.getDefaultUncaughtExceptionHandler() instanceof ApplicationCrashHandler)){
            Thread.setDefaultUncaughtExceptionHandler(new ApplicationCrashHandler());

        }


    }


    private ApplicationCrashHandler(){
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        // Place a breakpoint here to catch application crashes
        Log.wtf(TAG, String.format("Exception: %s\n%s", e.toString(), getStackTrace(e)));

        // Call the default handler
        defaultHandler.uncaughtException(t, e);

    }


    private String getStackTrace(Throwable e) {
        final Writer sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);

        e.printStackTrace(pw);
        String stacktrace = sw.toString();
        pw.close();

        return stacktrace;
    }
}
