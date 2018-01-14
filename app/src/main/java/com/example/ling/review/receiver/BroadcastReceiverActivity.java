package com.example.ling.review.receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ling.review.R;


public class BroadcastReceiverActivity extends AppCompatActivity {
    private MyBroadcastReceiver mBroadcastReceiver = null;
    private MyBroadcastReceiver2 mBroadcastReceiver2 = null;
    private LocalBroadcastManager mLocalBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        mBroadcastReceiver = new MyBroadcastReceiver();
        mBroadcastReceiver2 = new MyBroadcastReceiver2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 注册广播接收器
        //设置广播接收器将接收的广播类型
//        registerReceiverSystemBroadcast();
//        registerReceiverNormalBroadcast();
//        registerReceiverNormalBroadcast2();
        registerReceiverLocalBroadcast();
    }

    //   注册监听系统广播
    private void registerReceiverSystemBroadcast() {
        //用于接收网络状态改变时发出的广播
        final String action = "android.net.conn.CONNECTIVITY_CHANGE";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    //   注册监听普通广播
    private void registerReceiverNormalBroadcast() {
        final String action = "YOU_BROADCAST_RECEIVER_ACTION";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        intentFilter.setPriority(10);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    //   注册监听普通广播
    private void registerReceiverNormalBroadcast2() {
        final String action = "YOU_BROADCAST_RECEIVER_ACTION";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        intentFilter.setPriority(20);
        registerReceiver(mBroadcastReceiver2, intentFilter);
    }

    //   注册监听本地广播
    private void registerReceiverLocalBroadcast() {
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        final String action = "YOU_BROADCAST_RECEIVER_ACTION";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 解除注册广播接收器
        // unregisterReceiver(mBroadcastReceiver);
        // 解除注册本地广播广播接收器
        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
    }

    // 发送广播按钮点击事件
    public void onClickSendBroadcast(View view) {
        Intent intent = new Intent();
        //对应BroadcastReceiver中intentFilter的action
        intent.setAction("YOU_BROADCAST_RECEIVER_ACTION");
        intent.putExtra("msg", "哈哈哈");
        // 发送普通广播
//        sendBroadcast(intent);
        // 发送有序广播
//        sendOrderedBroadcast(intent, null);
        // 发送本地广播
        mLocalBroadcastManager.sendBroadcast(intent);
    }
}
