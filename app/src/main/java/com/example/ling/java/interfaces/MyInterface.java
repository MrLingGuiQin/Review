package com.example.ling.java.interfaces;

/**
 * ***************************************
 * statement:  接口的定义
 * author: LingGuiQin
 * date created : 2018/3/2 0002
 * ***************************************
 */
public interface MyInterface {
    int q = 1; // 默认是用 public static final 修饰  是个常量不可变
    // 以下方法默认 public abstract 修饰
    void a();

    void b();

    void c();
}
