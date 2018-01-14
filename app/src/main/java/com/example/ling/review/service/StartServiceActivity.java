package com.example.ling.review.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ling.review.R;


public class StartServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
    }

    public void onClickStartService(View view) {
        startService(new Intent(this, StartService.class));
    }

    public void onClickStopService(View view) {
        stopService(new Intent(this, StartService.class));
    }
}
