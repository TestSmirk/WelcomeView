package com.example.bzby.welcomeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String welcomeImageUrl = "http://img3.duitang.com/uploads/blog/201403/26/20140326140216_xednQ.thumb.700_0.jpeg";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WelcomeUtil.open(this, welcomeImageUrl, new WelcomeUtil.OnWelcomeDone() {
            @Override
            public void onDone() {
                Log.d(TAG, "onDone: ");
                setContentView(R.layout.activity_main);
            }
        });

    }
}
