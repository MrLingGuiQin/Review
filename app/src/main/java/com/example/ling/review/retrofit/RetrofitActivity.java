package com.example.ling.review.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ling.review.R;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        // 第一步创建  retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        // 第二步 实现 RequestApi 接口
        RequestApi api = retrofit.create(RequestApi.class);

        // 第三步 创建call
        Call<String> call = api.get("");

        // 第四步 执行call 进行网络请求
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(RetrofitActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                Log.e("retrofit异步请求成功 ：", response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("retrofit异步请求失败 ：", t.getMessage());
            }
        });
    }
}
