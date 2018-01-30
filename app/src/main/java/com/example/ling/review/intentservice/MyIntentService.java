package com.example.ling.review.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/29 0029
 * ***************************************
 */
public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getStringExtra("task_action");
        Log.d(TAG, "接收到任务：" + action + "开始执行！");
        SystemClock.sleep(3000); // 休眠3000秒，模拟耗时操作
        Log.d(TAG, action + "执行完毕！");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "服务已销毁关闭! ");
    }
}
