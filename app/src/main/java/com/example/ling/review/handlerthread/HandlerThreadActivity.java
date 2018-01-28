package com.example.ling.review.handlerthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ling.review.R;

public class HandlerThreadActivity extends AppCompatActivity {

    private HandlerThread mHandlerThread = null;
    private Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        // 创建一个handlerThread 线程,线程名字：mHandler-thread
        mHandlerThread = new HandlerThread("mHandler-thread");
        //开启一个线程
        mHandlerThread.start();

        // 在handlerThread线程中创建Handler
        //这个方法是运行在 mHandler-thread 线程中的 ，可以执行耗时操作
        mHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                //这个方法是运行在 mHandler-thread 线程中的 ，可以执行耗时操作
                Log.d("mHandler ", "消息： " + msg.what + "  线程： " + Thread.currentThread().getName());
            }
        };

        // 在主线程handler发送消息
        mHandler.sendEmptyMessage(1);

        //在子线程给handler发送消息
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(2);
            }
        }).start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 释放资源
        mHandlerThread.quit();
    }
}
