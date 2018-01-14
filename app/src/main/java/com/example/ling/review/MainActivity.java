package com.example.ling.review;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ling.review.ipc.aidl.Aidl2Activity;
import com.example.ling.review.ipc.aidl.AidlActivity;
import com.example.ling.review.ipc.parcelable.ParcelableActivity;
import com.example.ling.review.ipc.parcelable.User3;
import com.example.ling.review.receiver.BroadcastReceiverActivity;
import com.example.ling.review.service.BindServiceActivity;
import com.example.ling.review.service.StartServiceActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "AActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState()");
        String msg = savedInstanceState.getString("msg");
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState()");
        outState.putString("msg", "我要销毁重新创建啦");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }

    public void onClickStartService(View view) {
        startActivity(new Intent(this, StartServiceActivity.class));
    }

    public void onClickBindService(View view) {
        startActivity(new Intent(this, BindServiceActivity.class));
    }

    public void onClickBroadcastReceiver(View view) {
        startActivity(new Intent(this, BroadcastReceiverActivity.class));
    }

    // 测试Parcelable序列化方式传递对象
    public void onClickParcelable(View view) {
        final User3 user3 = new User3("ling", 22);
        final Intent intent = new Intent(this, ParcelableActivity.class);
        intent.putExtra("user", user3);
        startActivity(intent);
    }

    // 测试AIDL返回int
    public void onClickAidl(View view) {
        startActivity(new Intent(this, AidlActivity.class));
    }

    // 测试AIDL返回自定义person类型
    public void onClickAidl2(View view) {
        startActivity(new Intent(this, Aidl2Activity.class));
    }
}
