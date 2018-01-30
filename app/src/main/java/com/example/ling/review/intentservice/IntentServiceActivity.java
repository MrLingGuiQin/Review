package com.example.ling.review.intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent service = new Intent(this, MyIntentService.class);
        // 启动任务1
        service.putExtra("task_action", "任务1");
        startService(service);
        // 启动任务2
        service.putExtra("task_action", "任务2");
        startService(service);
        // 启动任务2
        service.putExtra("task_action", "任务3");
        startService(service);
    }
}
