package com.example.ling.bean;
import android.content.Intent;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/1/29 0029
 * ***************************************
 */
public class ActivityBean {
    public String title;
    public Intent intent;

    public ActivityBean(String title, Intent intent) {
        this.title = title;
        this.intent = intent;
    }
}
