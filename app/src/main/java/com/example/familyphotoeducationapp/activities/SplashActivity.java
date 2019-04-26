package com.example.familyphotoeducationapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.familyphotoeducationapp.R;
import com.example.familyphotoeducationapp.lifecycle.ApplicationWrapper;

public class SplashActivity extends AppCompatActivity {

    String TAG = "logtag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - ApplicationWrapper.startTime;

        if (elapsedTime > 300){
            Log.i(TAG,String.format("LONG STARTUP TIME"));
        }

        Log.i(TAG,String.format("Elapsed Time = %d ms ",elapsedTime));

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
