package com.example.ling.review.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ling.review.R;

import java.lang.ref.WeakReference;

public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler = new MainHandler(this);

    // Handler改为静态内部类，避免内存泄漏
    public static class MainHandler extends Handler {

        private WeakReference<HandlerActivity> mWeakReference = null;

        public MainHandler(HandlerActivity activity) {
            // 将Activity 包装成弱引用,避免内存泄漏
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            // 接收处理消息
            HandlerActivity activity = mWeakReference.get();
            if (activity != null) {
                Toast.makeText(activity, "我在UI线程上哦", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        initView();
    }

    private void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    // 第一种 post(runnable)用法
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "我在UI线程上哦2", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // 第二种 sendMessage(message)用法
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
