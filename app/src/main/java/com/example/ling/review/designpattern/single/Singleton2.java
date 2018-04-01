package com.example.ling.review.designpattern.single;

/**
 * ***************************************
 * statement: 懒汉式
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class Singleton2 {
    private static Singleton2 mSingleton2 = null;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (mSingleton2 == null) {
            synchronized (Singleton2.class){
                if (mSingleton2 == null) {
                    mSingleton2 = new Singleton2();
                }
            }
        }
        return mSingleton2;
    }
}
