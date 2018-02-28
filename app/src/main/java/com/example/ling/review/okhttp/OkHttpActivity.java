package com.example.ling.review.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.ling.review.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/2/24 0024
 * ***************************************
 */
public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        // 第一步 创建 OkHttpClient
        final OkHttpClient client = new OkHttpClient();

        // 第二步 创建 Request
        final Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .get()
                .build();

        // 第三步 创建call
        // 第四步 执行请求 call.execute() 同步请求、call.enqueue();异步请求

        findViewById(R.id.btn_get_sync).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在主线程请求网络会导致异常 android.os.NetworkOnMainThreadException
                final Call call = client.newCall(request);
                try {
                    Response response = call.execute();
                    Log.e("okHttp同步请求成功：", response.body().string());
                } catch (Exception e) {
                    Log.e("okHttp同步请求失败：", e.toString());
                }
            }
        });


        findViewById(R.id.btn_get_async).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("okHttp异步请求失败 ：", e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.e("okHttp异步请求成功 ：", response.body().string());
                    }
                });
            }
        });

    }


}
