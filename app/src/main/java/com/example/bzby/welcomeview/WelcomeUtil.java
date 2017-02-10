package com.example.bzby.welcomeview;

import android.app.Activity;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by bzby on 17-2-10.
 */

public class WelcomeUtil {

    interface OnWelcomeDone {
        void onDone();
    }

    private static final String TAG = "WelcomeUtil";

    public static void open(final Activity activity, String imageUrl, final OnWelcomeDone onWelcomeDone) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        final View welcome = LayoutInflater.from(activity).inflate(R.layout.welcome, null);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        welcome.startAnimation(alphaAnimation);
        Glide.with(activity).load(imageUrl).into(((ImageView) welcome.findViewById(R.id.iv_welcome)));
        activity.setContentView(welcome);
        final TextView skipView = (TextView) welcome.findViewById(R.id.tv_skip);

        final CountDownTimer start = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                skipView.setText("跳过" + ((millisUntilFinished / 1000) - 1));
            }

            @Override
            public void onFinish() {
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation1.setDuration(1000);
                welcome.startAnimation(alphaAnimation1);
                if (onWelcomeDone != null) {
                    onWelcomeDone.onDone();
                }
            }
        }.start();
        skipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.onFinish();
            }
        });

    }
}
