package com.example.ling.review;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ling.bean.ActivityBean;
import com.example.ling.review.asynctask.AsyncTaskActivity;
import com.example.ling.review.handler.HandlerActivity;
import com.example.ling.review.handler.HandlerActivity2;
import com.example.ling.review.handlerthread.HandlerThreadActivity;
import com.example.ling.review.intentservice.IntentServiceActivity;
import com.example.ling.review.ipc.aidl.Aidl2Activity;
import com.example.ling.review.ipc.aidl.AidlActivity;
import com.example.ling.review.ipc.parcelable.ParcelableActivity;
import com.example.ling.review.ipc.parcelable.User3;
import com.example.ling.review.receiver.BroadcastReceiverActivity;
import com.example.ling.review.service.BindServiceActivity;
import com.example.ling.review.service.StartServiceActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private List<ActivityBean> mList = new ArrayList();
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView = findViewById(R.id.rcy_main);
        mAdapter = new MainAdapter(mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void initData() {
        mList.add(new ActivityBean("StartService", new Intent(this, StartServiceActivity.class)));
        mList.add(new ActivityBean("BindService", new Intent(this, BindServiceActivity.class)));
        mList.add(new ActivityBean("BroadcastReceiver", new Intent(this, BroadcastReceiverActivity.class)));

        final Intent intent = new Intent(this, ParcelableActivity.class);
        intent.putExtra("user", new User3("ling", 22));
        mList.add(new ActivityBean("测试Parcelable传递数据", intent));
        mList.add(new ActivityBean("AIDL传输int", new Intent(this, AidlActivity.class)));
        mList.add(new ActivityBean("AIDL传输自定义数据", new Intent(this, Aidl2Activity.class)));
        mList.add(new ActivityBean("主线程使用Handler", new Intent(this, HandlerActivity.class)));
        mList.add(new ActivityBean("子线程使用Handler", new Intent(this, HandlerActivity2.class)));
        mList.add(new ActivityBean("AsyncTask", new Intent(this, AsyncTaskActivity.class)));
        mList.add(new ActivityBean("HandlerThread", new Intent(this, HandlerThreadActivity.class)));
        mList.add(new ActivityBean("IntentService", new Intent(this, IntentServiceActivity.class)));
    }
}
