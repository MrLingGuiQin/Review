package com.example.ling.review.designpattern.single;

/**
 * ***************************************
 * statement: 饿汉式单列
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class Singleton {
    private static Singleton mSingleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return mSingleton;
    }

}
