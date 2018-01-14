package com.example.ling.review;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void goDActivity(View view) {
//        Intent intent = new Intent(Intent.ACTION_MAIN);
        Intent intent = new Intent("android.intent.123456");
//        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.example.ling.bapp", "com.example.ling.bapp.DActivity");
        intent.setComponent(cn);
        startActivity(intent);
    }
}
