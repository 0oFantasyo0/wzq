package com.wuziqi.love.fantasy.faith;

import android.app.Application;

import im.fir.sdk.FIR;

/**
 * FIR.IM检测更新用
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        FIR.init(this);
    }
}

