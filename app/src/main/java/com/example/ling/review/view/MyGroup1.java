package com.example.ling.review.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/2/7 0007
 * ***************************************
 */
public class MyGroup1 extends LinearLayout {
    public static final String TAG = "MyGroup1";

    public MyGroup1(Context context) {
        super(context);
    }

    public MyGroup1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroup1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
