package com.example.ling.review;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.ling.bean.ActivityBean;
import com.example.ling.review.asynctask.AsyncTaskActivity;
import com.example.ling.review.butterknife.ButterknifeActivity;
import com.example.ling.review.byone.ByoneActivity;
import com.example.ling.review.chart.ChartActivity;
import com.example.ling.review.handler.HandlerActivity;
import com.example.ling.review.handler.HandlerActivity2;
import com.example.ling.review.handlerthread.HandlerThreadActivity;
import com.example.ling.review.intentservice.IntentServiceActivity;
import com.example.ling.review.ipc.aidl.Aidl2Activity;
import com.example.ling.review.ipc.aidl.AidlActivity;
import com.example.ling.review.ipc.parcelable.ParcelableActivity;
import com.example.ling.review.ipc.parcelable.User3;
import com.example.ling.review.listview.ListViewActivity;
import com.example.ling.review.mvc.contronller.StudentMVCActivity;
import com.example.ling.review.mvp.view.StudentMVPActivity;
import com.example.ling.review.mvvm.view.StudentMVVMActivity;
import com.example.ling.review.okhttp.OkHttpActivity;
import com.example.ling.review.receiver.BroadcastReceiverActivity;
import com.example.ling.review.retrofit.RetrofitActivity;
import com.example.ling.review.service.BindServiceActivity;
import com.example.ling.review.service.StartServiceActivity;
import com.example.ling.review.view.EventActivity;
import com.example.ling.review.view.EventActivity2;
import com.example.ling.review.view.TestPagerActivity;
import com.example.ling.review.view.TestViewActivity;

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
        mList.add(new ActivityBean("TestView", new Intent(this, TestViewActivity.class)));
        mList.add(new ActivityBean("TestMyViewPager", new Intent(this, TestPagerActivity.class)));
        mList.add(new ActivityBean("TestEvent", new Intent(this, EventActivity.class)));
        mList.add(new ActivityBean("TestEvent2", new Intent(this, EventActivity2.class)));
        mList.add(new ActivityBean("ListView", new Intent(this, ListViewActivity.class)));
        mList.add(new ActivityBean("OkHttp", new Intent(this, OkHttpActivity.class)));
        mList.add(new ActivityBean("Retrofit", new Intent(this, RetrofitActivity.class)));
        mList.add(new ActivityBean("Butterknife", new Intent(this, ButterknifeActivity.class)));
        mList.add(new ActivityBean("MVC", new Intent(this, StudentMVCActivity.class)));
        mList.add(new ActivityBean("MVP", new Intent(this, StudentMVPActivity.class)));
        mList.add(new ActivityBean("MVVM", new Intent(this, StudentMVVMActivity.class)));
        mList.add(new ActivityBean("定义刻度条", new Intent(this, ByoneActivity.class)));
        mList.add(new ActivityBean("图表折线图", new Intent(this, ChartActivity.class)));
    }

    /**
     * 在 onStop 之前调用
     * activity 异常被销毁杀死时会回调该方法
     * 我们可以通过 Bundle 进行保存数据
     * 当Activity被重新创建时 从 Bundle 取出数据进行回显
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    /**
     * 当Activity重新创建时 会在 onstart 之后调用
     * 从 Bundle 中取出销毁时保存的数据进行恢复
     *
     * @param savedInstanceState
     */

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
