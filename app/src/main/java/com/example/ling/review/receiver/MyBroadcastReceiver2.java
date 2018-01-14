package com.example.ling.review.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * ***************************************
 * statement: 自定义广播接收器2
 * author: LingGuiQin
 * date created : 2018/1/2 0002
 * ***************************************
 */

public class MyBroadcastReceiver2 extends BroadcastReceiver {

    // 接收广播方法，在intent中我们可以取出发送广播是携带的数据.
    @Override
    public void onReceive(Context context, Intent intent) {
        // 接收到广播，处理需要的逻辑
        Toast.makeText(context, "2222222222", Toast.LENGTH_SHORT).show();
    }
}