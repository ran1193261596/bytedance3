package com.ss.android.ugc.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.ss.android.ugc.demo.widget.Clock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ClockActivity extends AppCompatActivity {
    public static final int MSG_QUERY_STOCK = 100;
    private View mRootView;
    private Clock mClockView;
    private final ClockHandlerThread  clockHandler = new ClockHandlerThread("name") {
        @Override public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MSG_QUERY_STOCK:
                    mClockView.invalidate();
                    clockHandler.mHandler.sendEmptyMessageDelayed(MSG_QUERY_STOCK,  1000);
                    break;
                default:
                    break;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);
        clockHandler.start();
    }
}
