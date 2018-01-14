package com.example.ling.review.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/1 0001
 * ***************************************
 */
public class BindService extends Service {
    private final String TAG = getClass().getName();
    private final MyBinder mBinder = new MyBinder();
    private final String mMessage = "我是Service的数据哈";

    // 通过继承Binder来实现IBinder接口
    // service允许客户端通过IBinder对象来访问Service内部数据
    public class MyBinder extends Binder {
        // 获取Service的mMessage数据
        public String getServiceMessage() {
            return mMessage;
        }
    }

    // service被创建时回调
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service is create");
    }

    // service被绑定时回调
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Service is bind");
        return mBinder;
    }

    // service 被启动时回调
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service is start");
        return super.onStartCommand(intent, flags, startId);
    }

    // service 被解绑时回调
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "Service is unbind");
        return super.onUnbind(intent);
    }

    // service 被销毁时回调
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service is destroy");
    }
}
