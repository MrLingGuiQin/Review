package com.example.ling.review.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.ling.review.R;


public class BindServiceActivity extends AppCompatActivity {
    private final String TAG = getClass().getName();
    private BindService.MyBinder mBinder = null;
    private boolean mIsBind = false;


    // Activity 与 Service 连接状态监听类
    private ServiceConnection mConn = new ServiceConnection() {
        // 连接成功回调方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");
            // 获取Service onBind方法返回的MyBinder对象。
            mBinder = (BindService.MyBinder) service;
        }

        // 连接失败出现异常的回调方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBinder = null;
            Log.d(TAG, "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
    }

    // 绑定服务按钮点击事件
    public void onClickBindService(View view) {
        Intent intent = new Intent(this, BindService.class);
        bindService(intent, mConn, BIND_AUTO_CREATE);
        mIsBind = true;
    }

    // 解绑服务按钮点击事件
    public void onClickUnbindService(View view) {
        if (mIsBind) {
            unbindService(mConn);
            mIsBind = false;
        }
    }

    // 获取Service内部数据按钮点击事件
    public void onClickGetServiceData(View view) {
        // 通过MyBinder获取Service内部数据。
        if (mBinder != null) {
            final String message = mBinder.getServiceMessage();
            Log.d(TAG, "获取Service的内部数据：message = " + message);
        }
    }
}
