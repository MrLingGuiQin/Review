package com.example.ling.review.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ling.review.R;

/**
 * ***************************************
 * statement: 子线程与子线程间发送消息
 * author: LingGuiQin
 * date created : 2018/1/14 0014
 * ***************************************
 */
public class HandlerActivity2 extends AppCompatActivity {

    private ThreadHandler mHandler;

    // Handler改为静态内部类，避免内存泄漏
    public static class ThreadHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            // 接收处理消息
            Log.d("TAG", "接收消息啦----- 当前线程为：" + Thread.currentThread().getName());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        newThread1();
        newThread2();
    }

    /**
     * 创建子线程1 创建Handler
     */
    private void newThread1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "当前线程为：" + Thread.currentThread().getName());
                // 1、创建Looper
                Looper.prepare();
                // 2、创建Handler
                mHandler = new ThreadHandler();
                // 3、Looper开始轮询
                Looper.loop();
            }
        }).start();
    }

    /**
     * 创建子线程2 用子线程1的handler 发送消息
     */
    private void newThread2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("TAG", "当前线程为：" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    Message message = Message.obtain();
                    mHandler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // activity 销毁时 Handler 移除所有回调和信息
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }
}
