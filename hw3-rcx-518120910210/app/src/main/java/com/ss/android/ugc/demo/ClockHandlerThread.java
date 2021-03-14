package com.ss.android.ugc.demo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

abstract public class ClockHandlerThread extends HandlerThread implements Handler.Callback {
    public static final int MSG_QUERY_STOCK = 100;
//    Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
//    int hour = c.get(Calendar.HOUR_OF_DAY);
//    int minute = c.get(Calendar.MINUTE);
//    int second = c.get(Calendar.SECOND);

    public Handler mHandler;

    public ClockHandlerThread(String name) {
        super(name);
    }

    @Override protected void onLooperPrepared() {
        super.onLooperPrepared();
        mHandler = new Handler(getLooper(), this);
        //首次请求

        mHandler.sendEmptyMessage(MSG_QUERY_STOCK);
    }


}
